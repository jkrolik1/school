#include "updatetable.h"
#include "ui_updatetable.h"
#include "connection.h"

#include <QSqlDatabase>
#include <QSqlQueryModel>
#include <QSqlError>
#include <QMessageBox>

#include <unordered_map>


QVector<QLabel*> la2;
QVector<QLineEdit*> le2;
QString foreQ = "";
QSqlQueryModel *model7 = nullptr, *model8 = nullptr, *model9 = nullptr;

updateTable::updateTable(QWidget *parent) :
    QDialog(parent),
    ui(new Ui::updateTable)
{
    ui->setupUi(this);
    ui->tableView->setVisible(0);
    ui->tableView_2->setVisible(0);
    ui->tableView_3->setVisible(0);
    ui->label->setVisible(0);
    ui->lineEdit->setVisible(0);
    ui->lineEdit_2->setVisible(0);
}

bool updateTable::updateData(const QModelIndex &index, QString name)
{
    model7 = new QSqlQueryModel();
    model8 = new QSqlQueryModel();
    model9 = new QSqlQueryModel();
    QSqlQuery idQ, values, columnName, constaint, it2;
    QString x,y, columnID, iValue = "", myQuery, columnNameQ, constaintQ, itQ;
    QString tableName = getTableName();
    int it = 0;
    int ax=10,ay=10;
    int ax2=220,ay2=13;
    int row;
    QRegExp re("\\d*");


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
        la2[it]->setGeometry(ax,ay,300,30);
        la2[it]->resize(300,30);
        la2[it]->show();
        la2[it]->setStyleSheet(this->getLabelStyle());
        ay += 30;

        le2.append(new QLineEdit(this));
        le2[it]->setGeometry(ax2,ay2,200,25);
        le2[it]->resize(200,25);
        le2[it]->setText(iValue);
        le2[it]->show();
        le2[it]->setStyleSheet(this->getLineEditStyle());
        ay2 += 30;

        it += 1;

        delete model8;
    }

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

    for(auto &&leItem : le2)   { delete leItem; leItem = NULL; }
    le2.clear();
    for(auto &&laItem : la2)   { delete laItem; laItem = NULL; }
    la2.clear();
}

void updateTable::on_pushButton_clicked()
{
    QSqlQuery updateQuery, dateQ, sessionQ;
    QString tableName = getTableName(), query, h = "", date;
    QRegExp re("\\d*");
    int o = 0;
    bool ok = false, end = false;
    QMessageBox msgCritical2(
                QMessageBox::Critical,
                "Status zmian",
                "Wystąpił błąd. Nie wprowadzono zmian, "
                "ponieważ wpisana data ma nieprawidłowy format. "
                "Spróbuj wprowadzić datę w formacie DD/MM/RRRR",
                QMessageBox::Cancel);

    msgCritical2.setButtonText(QMessageBox::Cancel, "Wyjdź");

    query = "UPDATE " + tableName + " SET ";

    for(int c = 0; c < la2.size(); ++c)
    {
        if(newRows[la2[c]->text()] == "DATE")
        {
            query += "\"";
            query += la2[c]->text();
            query += "\" = '?', ";
        }
        else if(newRows[la2[c]->text()] == "VARCHAR" ||
                newRows[la2[c]->text()] == "VARCHAR2" ||
                newRows[la2[c]->text()] == "CHAR")
        {
            query += "\"";
            query += la2[c]->text();
            query += "\" = '?', ";
        }
        else
        {
            query += "\"";
            query += la2[c]->text();
            query += "\" = ?, ";
        }
    }

    query = query.mid(0,query.size()-2);
    query += foreQ;

    updateQuery.prepare(query);

    for(int c = 0; c < le2.size(); ++c)
    {
        if(newRows[la2[c]->text()] == "DATE")
        {
            date =  "select to_date('"
                    + le2[c]->text() +
                    "','DD/MM/YYYY') "
                    "result from dual";
            dateQ.prepare(date);

            if(dateQ.exec())
            {
                h = le2[c]->text();
                updateQuery.addBindValue(h);
                continue;
            }
            else
            {
                msgCritical2.exec();
                end = true;
                break;
            }
        }
        if(re.exactMatch(le2[c]->text()))
        {
            o = (le2[c]->text()).toInt(&ok);
            if (ok)
                updateQuery.addBindValue(o);
        }
        else
        {
            h = le2[c]->text();
            updateQuery.addBindValue(h);
        }
    }

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
                "Status operacji zmiany",
                "Wystąpił błąd. Nie wprowadzono zmian.\n" + query,
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
                    msgCritical.exec();
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
