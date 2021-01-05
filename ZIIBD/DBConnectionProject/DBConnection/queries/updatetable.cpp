#include "updatetable.h"
#include "ui_updatetable.h"
#include "connection.h"

#include <QSqlDatabase>
#include <QSqlQueryModel>
#include <QSqlError>
#include <QMessageBox>
#include <QDebug>
#include <QPushButton>
#include <unordered_map>


QVector<QLabel*> la2;
QVector<QLineEdit*> le2;
QFormLayout *formLayout = nullptr;
QPushButton *button = nullptr;
QString foreQ = "";
QSqlQueryModel *model7 = nullptr, *model8 = nullptr, *model9 = nullptr;

updateTable::updateTable(QWidget *parent) :
    QDialog(parent),
    ui(new Ui::updateTable)
{
    setWindowFlags(Qt::WindowMinimizeButtonHint |
                   Qt::WindowMaximizeButtonHint |
                   Qt::WindowCloseButtonHint);

    ui->setupUi(this);
    ui->tableView->setVisible(0);
    ui->tableView_2->setVisible(0);
    ui->tableView_3->setVisible(0);
    ui->label->setVisible(0);
    ui->lineEdit->setVisible(0);
    ui->lineEdit_2->setVisible(0);
}

template<typename t>
std::vector<t> updateTable::uniqueVector(std::vector<t>& input)
{
    typename std::vector<t>::iterator it;
    std::sort(input.begin(),input.end());
    it = std::unique(input.begin(),input.end());
    input.resize(std::distance(input.begin(),it));

    return input;
}

std::tuple<bool,std::vector<QString>> updateTable::validation()
{
    std::tuple<bool,std::vector<QString>> returnTuple;
    std::vector<QString> errorColumnNames;
    QString columnType,currentValue;
    int intIterator = 0;
    bool returnBool = true;
    unsigned int sizeMap = newRows.size(), sizeLa = la2.size(), sizeLe = le2.size();

    if (!((sizeMap == sizeLa) && (sizeLa == sizeLe) && (sizeMap == sizeLe)))
        return std::make_tuple(false, errorColumnNames);

    for(auto &&dt : newRows)
    {
        columnType = dt.second;
        currentValue = le2[intIterator]->text();

        if (currentValue.isEmpty())
        {
            returnBool = false;
            errorColumnNames.push_back(la2[intIterator]->text());
        }

        if (columnType == "DATE")
        {
            if (!(checkDATE(currentValue)))
            {
                returnBool = false;
                errorColumnNames.push_back(la2[intIterator]->text());
            }
        }
        else if (columnType == "NUMBER")
        {
            if (!(checkNUMBER(currentValue)))
            {
                returnBool = false;
                errorColumnNames.push_back(la2[intIterator]->text());
            }
        }
        else if (columnType == "VARCHAR2")
        {
            if (!(checkVARCHAR2(currentValue)))
            {
                returnBool = false;
                errorColumnNames.push_back(la2[intIterator]->text());
            }
        }
        else if (columnType == "CHAR")
        {
            if (!(checkCHAR(currentValue)))
            {
                returnBool = false;
                errorColumnNames.push_back(la2[intIterator]->text());
            }
        }
        else if (columnType == "TIMESTAMP")
        {
            if (!(checkTIMESTAMP(currentValue)))
            {
                returnBool = false;
                errorColumnNames.push_back(la2[intIterator]->text());
            }
        }
        else
        {
            // other type
        }

        intIterator += 1;
    }

    return std::make_tuple(returnBool, errorColumnNames);
}

bool updateTable::checkDATE(QString x)
{
    QSqlQuery date;
    QString dFormat = getDateFormat();

    date.prepare(   "select to_date('"
                    + x +
                    "','" + dFormat + "') "
                    "result from dual"
                );

    if(date.exec())
        return true;

    return false;
}

bool updateTable::checkNUMBER(QString x)
{
    bool ok = false,ok2 = true;
    x.toInt(&ok);

    for (int i=0; i<x.size(); ++i)
    {
        if (!(x[i].isDigit()))
        {
            ok2 = false;
            break;
        }
    }

    return ok && ok2;
}

bool updateTable::checkVARCHAR2(QString x)
{
    QRegExp re("[a-zA-Z0-9.,:;_-'() ]+");

    if(re.exactMatch(x))
        return true;

    return false;
}

bool updateTable::checkCHAR(QString x)
{
    // fixed length ???

    QRegExp re("[a-zA-Z0-9.,:;_-'() ]+");

    if(re.exactMatch(x))
        return true;

    return false;
}

bool updateTable::checkTIMESTAMP(QString x)
{
    return true;
}

QString updateTable::getPushButtonStyle()
{
    return this->cs3;
}

void updateTable::setDateFormat(QString df)
{
    this->dateFormat = df;
}

QString updateTable::getDateFormat()
{
    return this->dateFormat;
}

void updateTable::setColumnIDvalue(QString parametr)
{
    this->columnIDvalue = parametr;
}

QString updateTable::getRedLineEditStyle()
{
    return this->csRed;
}

bool updateTable::updateData(QString name, std::vector<QString> redColumns)
{
    this->setColumnIDvalue(name);
    model7 = new QSqlQueryModel();
    model8 = new QSqlQueryModel();
    model9 = new QSqlQueryModel();
    formLayout = new QFormLayout();
    button = new QPushButton("Zmień");
    QSqlQuery idQ, values, columnName, constaint, it2;
    QString x,y, columnID, iValue = "", myQuery, columnNameQ, constaintQ, itQ;
    QString tableName = getTableName();
    int it = 0, it_ = 0;
    int ax=10,ay=10;
    int ax2=220,ay2=13;
    int row;
    QRegExp re("\\d*");
    bool redStyle = false;


    for(auto &&leItem : le2)   { delete leItem; leItem = NULL; }
    le2.clear();
    for(auto &&laItem : la2)   { delete laItem; laItem = NULL; }
    la2.clear();
    newRows.clear();

    columnNameQ =
            "select COLUMN_NAME, data_type from ALL_TAB_COLUMNS where TABLE_NAME='"
            +tableName.toUpper()+"'";
    columnName.prepare(columnNameQ);

    if(columnName.exec())
    {
        model7->setQuery(columnName);
        ui->tableView->setModel(model7);
    }

    columnID =  "SELECT cols.column_name "
                "FROM all_constraints cons, all_cons_columns cols "
                "WHERE cols.table_name = '" + tableName.toUpper() + "' "
                "AND cons.constraint_type = 'P' "
                "AND cons.constraint_name = cols.constraint_name "
                "AND cons.owner = cols.owner "
                "ORDER BY cols.table_name, cols.position";
    idQ.prepare(columnID);

    if(idQ.exec())
    {
        model8->setQuery(idQ);
        ui->tableView_2->setModel(model8);
        columnID =
                ui->tableView_2->model()->data
                (ui->tableView_2->model()->index(0,0)).toString();
    }

    if (columnID.isEmpty())
    {
        QMessageBox msgCritical(
                    QMessageBox::Critical,
                    "Pojawił się błąd!",
                    "Nie jesteśmy w stanie dokonac zmian, ponieważ tabela "
                    + tableName + " nie ma klucza podstawowego.",
                    QMessageBox::Cancel);

        msgCritical.setButtonText(QMessageBox::Cancel, "Wyjdź");

        msgCritical.exec();
        updateTable::close();
        return 0;
    }

    row = model7->rowCount();
    for(int i=0; i<row; ++i)
    {
        x = ui->tableView->model()->    // column name
                 data(ui->tableView->model()->index(i,0)).toString();
        y = ui->tableView->model()->    // column type
                 data(ui->tableView->model()->index(i,1)).toString();

        newRows.insert(std::pair<QString,QString>(x,y));
    }

    // disable constraints

    constaintQ =    "SELECT p.constraint_name, c.constraint_name "
                    "FROM all_constraints p "
                    "JOIN all_constraints c ON(p.constraint_name=c.r_constraint_name) "
                    "WHERE (p.constraint_type = 'P' OR p.constraint_type = 'U') "
                    "AND c.constraint_type = 'R' "
                    "AND p.table_name = '" + tableName.toUpper() + "'";
    constaint.prepare(constaintQ);

    if(constaint.exec())
    {
        model9->setQuery(constaint);
        ui->tableView->setModel(model9);
        row = model9->rowCount();

        for(int d=0; d<row; ++d)
        {
            constaintQ =
                    ui->tableView->model()->data
                    (ui->tableView->model()->index(d,0)).toString();

            itQ = "alter table " + tableName + " DISABLE constraint " +
                    constaintQ;

            it2.prepare(itQ);
            it2.exec();

            constaintQ =
                    ui->tableView->model()->data
                    (ui->tableView->model()->index(d,1)).toString();

            itQ = "alter table " + tableName + " DISABLE constraint " +
                    constaintQ;

            it2.prepare(itQ);
            it2.exec();
        }
    }

    constaintQ =    "SELECT constraint_name "
                    "FROM user_cons_columns "
                    "WHERE table_name = '" + tableName.toUpper() + "'";
    constaint.prepare(constaintQ);

    if(constaint.exec())
    {
        model9->setQuery(constaint);
        ui->tableView->setModel(model9);
        row = model9->rowCount();

        for(int d=0; d<row; ++d)
        {
            constaintQ =
                    ui->tableView->model()->data
                    (ui->tableView->model()->index(d,0)).toString();

            itQ = "alter table " + tableName + " DISABLE constraint " +
                    constaintQ;

            it2.prepare(itQ);
            it2.exec();
        }
    }
    //

    for(auto &&t : newRows)
    {
        QSqlQueryModel *model8 = new QSqlQueryModel();

        myQuery = ("select " + t.first + " from " + tableName +
                   " where " + columnID + " = '" + name + "'");
        values.prepare(myQuery);

        if(values.exec())
        {
            model8->setQuery(values);
            ui->tableView->setModel(model8);

            QModelIndex newIndex = ui->tableView->model()->index(0,0);
            int row2 = newIndex.row();
            int col2 = newIndex.column();
            iValue = ui->tableView->model()->data
                    (ui->tableView->model()->index(row2,col2)).toString();
        }

        la2.append(new QLabel(this));
        la2[it]->setText(t.first);

        if (!(redColumns.empty()))
        {
            if (la2[it]->text() == redColumns[it_])
            {
                it_ += 1;
                redStyle = true;
            }
        }

        la2[it]->setGeometry(ax,ay,300,30);
        la2[it]->resize(300,30);
        la2[it]->show();
        la2[it]->setStyleSheet(this->getLabelStyle());
        ay += 30;

        le2.append(new QLineEdit(this));
        le2[it]->setGeometry(ax2,ay2,200,25);
        le2[it]->resize(200,25);

        if (newRows[la2[it]->text()] == "DATE")
            iValue = iValue.mid(0,10);

        le2[it]->setText(iValue);
        le2[it]->show();

        if (redStyle)
            le2[it]->setStyleSheet(this->getRedLineEditStyle());
        else
            le2[it]->setStyleSheet(this->getLineEditStyle());

        ay2 += 30;

        formLayout->addRow(la2[it], le2[it]);

        it += 1;
        redStyle = false;

        delete model8;
    }

    button->setStyleSheet(this->getPushButtonStyle());
    connect(button, SIGNAL(clicked()), this, SLOT(updateClicked()));
    formLayout->addWidget(button);
    setLayout(formLayout);

    if(re.exactMatch(name))
        foreQ = " where " + columnID + " = " + name;
    else
        foreQ = " where " + columnID + " = '" + name + "'";

    return 1;
}

QString updateTable::getLabelStyle()
{
    return this->cs1;
}

QString updateTable::getLineEditStyle()
{
    return this->cs2;
}

void updateTable::setTableName(QString tableName)
{
    this->tableName = tableName;
}

QString updateTable::getTableName()
{
    return this->tableName;
}

updateTable::~updateTable()
{
    delete ui;

    delete model7;
    model7 = NULL;

    delete model8;
    model8 = NULL;

    delete model9;
    model9 = NULL;

    delete formLayout;
    formLayout = NULL;
    delete button;
    button = NULL;

    delete newUpdate;
    newUpdate = NULL;

    for(auto &&leItem : le2)   { delete leItem; leItem = NULL; }
    le2.clear();
    for(auto &&laItem : la2)   { delete laItem; laItem = NULL; }
    la2.clear();
}

void updateTable::updateClicked()
{
    QSqlQuery updateQuery;
    QString tableName = getTableName(), query, dateFormat = getDateFormat(), errorColumns;
    bool end = false;
    QMessageBox msgCritical2(
                QMessageBox::Critical,
                "Status zmian",
                "Wystąpił błąd. Nie wprowadzono zmian, "
                "ponieważ wpisana data ma nieprawidłowy format. "
                "Spróbuj wprowadzić datę w formacie " + dateFormat,
                QMessageBox::Cancel);
    bool status = std::get<0>(validation());
    typedef std::vector<QString> errorsV;
        errorsV columnsError = std::get<1>(validation());
        errorsV columnsError2 = uniqueVector(columnsError);
    newUpdate = new updateTable;

    msgCritical2.setButtonText(QMessageBox::Cancel, "Wyjdź");


    if (!(status))
    {
        for (auto &&y : columnsError2)
        {
            errorColumns += y;
            errorColumns += ", ";
        }

        QMessageBox msgCritical2(
                    QMessageBox::Critical,
                    "Błąd walidacji",
                    "Wystąpił błąd. Nie wprowadzono zmian.\n"
                    "Poprawy wymagają wpisane wartości w kolumnach: \n"
                    + errorColumns.mid(0,errorColumns.size()-2),
                    QMessageBox::Cancel);
        msgCritical2.setButtonText(QMessageBox::Cancel, "Wyjdź");

        qInfo() << "Validation ERROR";
        msgCritical2.exec();

        newUpdate->setTableName(tableName);
        newUpdate->setDateFormat("YYYY-MM-DD");
        newUpdate->setWindowTitle("Zmień w tabeli " + tableName);

        if(newUpdate->updateData(this->columnIDvalue,columnsError2))
            newUpdate->show();

        updateTable::close();
        return;
    }

    query = "UPDATE " + tableName + " SET ";

    for(int c = 0; c < la2.size(); ++c)
    {
        if(newRows[la2[c]->text()] == "DATE")
        {
            query += "\"";
            query += la2[c]->text();
            query += "\" = to_date('";
            query += le2[c]->text();
            query += "','";
            query += dateFormat;
            query += "'), ";
        }
        else if(newRows[la2[c]->text()] == "VARCHAR" ||
                newRows[la2[c]->text()] == "VARCHAR2" ||
                newRows[la2[c]->text()] == "CHAR")
        {
            query += "\"";
            query += la2[c]->text();
            query += "\" = '";
            query += le2[c]->text();
            query += "', ";
        }
        else
        {
            query += "\"";
            query += la2[c]->text();
            query += "\" = ";
            query += le2[c]->text();
            query += ", ";
        }
    }

    query = query.mid(0,query.size()-2);
    query += foreQ;

    updateQuery.prepare(query);

    QMessageBox msgBox(
                QMessageBox::Question,
                "Potwierdzenie zmiany rekordu",
                "Czy chcesz zatwierdzić swoje zmiany?",
                QMessageBox::Yes | QMessageBox::No);
    QMessageBox msgInfo(
                QMessageBox::Information,
                "Status operacji zmiany",
                "Wprowadzono zmiany",
                QMessageBox::Ok);
    QMessageBox msgCritical(
                QMessageBox::Critical,
                "Błąd w poleceniu SQL",
                "Wystąpił błąd. Nie wprowadzono zmian.\n",
                QMessageBox::Cancel);

    msgBox.setButtonText(QMessageBox::Yes, "Zmień");
    msgBox.setButtonText(QMessageBox::No, "Wyjdź");
    msgCritical.setButtonText(QMessageBox::Cancel, "Wyjdź");

    updateTable::setWindowOpacity(0.9);

    if(!end)
    {
        switch(msgBox.exec())
        {
            case QMessageBox::Yes:
                if(updateQuery.exec())
                {
                    QSqlDatabase::database().commit();
                    msgInfo.exec();
                    updateTable::close();
                }
                else
                {
                    msgCritical.exec();
                    newUpdate->setTableName(tableName);
                    newUpdate->setDateFormat("YYYY-MM-DD");
                    newUpdate->setWindowTitle("Zmień w tabeli " + tableName);

                    if(newUpdate->updateData(this->columnIDvalue,columnsError2))
                        newUpdate->show();
                }
            break;
            case QMessageBox::No:
                updateTable::close();
            break;
            default:
                updateTable::close();
            break;
        }
    }

    // enable constraints
    QString constaintQ =    "SELECT constraint_name "
                            "FROM user_cons_columns "
                            "WHERE table_name = '" + tableName.toUpper() + "'";
    QSqlQuery constaint, it2;
    constaint.prepare(constaintQ);

    QString itQ;
    int row;

    if(constaint.exec())
    {
        model9->setQuery(constaint);
        ui->tableView->setModel(model9);
        row = model9->rowCount();

        for(int d=0; d<row; ++d)
        {
            constaintQ =
                    ui->tableView->model()->data
                    (ui->tableView->model()->index(d,0)).toString();

            itQ = "alter table " + tableName + " ENABLE constraint " +
                    constaintQ;

            it2.prepare(itQ);
            it2.exec();
        }
    }

    constaintQ =    "SELECT p.constraint_name, c.constraint_name "
                    "FROM all_constraints p "
                    "JOIN all_constraints c ON(p.constraint_name=c.r_constraint_name) "
                    "WHERE (p.constraint_type = 'P' OR p.constraint_type = 'U') "
                    "AND c.constraint_type = 'R' "
                    "AND p.table_name = '" + tableName.toUpper() + "'";
    constaint.prepare(constaintQ);

    if(constaint.exec())
    {
        model9->setQuery(constaint);
        ui->tableView->setModel(model9);
        row = model9->rowCount();

        for(int d=0; d<row; ++d)
        {
            constaintQ =
                    ui->tableView->model()->data
                    (ui->tableView->model()->index(d,0)).toString();

            itQ = "alter table " + tableName + " ENABLE constraint " +
                    constaintQ;

            it2.prepare(itQ);
            it2.exec();

            constaintQ =
                    ui->tableView->model()->data
                    (ui->tableView->model()->index(d,1)).toString();

            itQ = "alter table " + tableName + " ENABLE constraint " +
                    constaintQ;

            it2.prepare(itQ);
            it2.exec();
        }
    }

    //

    QSqlDatabase::database().commit();
    updateTable::close();
}
