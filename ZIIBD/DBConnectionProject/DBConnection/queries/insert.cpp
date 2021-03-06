#include "insert.h"
#include "ui_insert.h"
#include "connection.h"

#include <QSqlDatabase>
#include <QSqlQueryModel>
#include <QPushButton>
#include <QDebug>
#include <QMessageBox>

#include <unordered_map>
#include <algorithm>
#include <iterator>


Insert::Insert(QWidget *parent) :
    QDialog(parent),
    ui(new Ui::Insert)
{
    setWindowFlags(Qt::WindowMinimizeButtonHint |
                   Qt::WindowMaximizeButtonHint |
                   Qt::WindowCloseButtonHint);
    ui->setupUi(this);
    ui->label->setVisible(0);
    ui->lineEdit->setVisible(0);
}

template<typename t>
std::vector<t> Insert::uniqueVector(std::vector<t>& input)
{
    typename std::vector<t>::iterator it;
    std::sort(input.begin(),input.end());
    it = std::unique(input.begin(),input.end());
    input.resize(std::distance(input.begin(),it));

    return input;
}

void Insert::setDateFormat(QString df)
{
    this->dateFormat = df;
}

QString Insert::getDateFormat()
{
    return this->dateFormat;
}

std::tuple<bool,std::vector<QString>> Insert::validation()
{
    std::tuple<bool,std::vector<QString>> returnTuple;
    std::vector<QString> errorColumnNames;
    QString columnType,currentValue;
    int intIterator = 0;
    bool returnBool = true;
    unsigned int sizeMap = newRows.size(), sizeLa = la.size(), sizeLe = le.size();

    if (!((sizeMap == sizeLa) && (sizeLa == sizeLe) && (sizeMap == sizeLe)))
        return std::make_tuple(false, errorColumnNames);

    for(auto &&dt : newRows)
    {
        columnType = dt.second;
        currentValue = le[intIterator]->text();

        if (currentValue.isEmpty())
        {
            returnBool = false;
            errorColumnNames.push_back(la[intIterator]->text());
        }

        if (columnType == "DATE")
        {
            if (!(checkDATE(currentValue)))
            {
                returnBool = false;
                errorColumnNames.push_back(la[intIterator]->text());
            }
        }
        else if (columnType == "NUMBER")
        {
            if (!(checkNUMBER(currentValue)))
            {
                returnBool = false;
                errorColumnNames.push_back(la[intIterator]->text());
            }
        }
        else if (columnType == "VARCHAR2")
        {
            if (!(checkVARCHAR2(currentValue)))
            {
                returnBool = false;
                errorColumnNames.push_back(la[intIterator]->text());
            }
        }
        else if (columnType == "CHAR")
        {
            if (!(checkCHAR(currentValue)))
            {
                returnBool = false;
                errorColumnNames.push_back(la[intIterator]->text());
            }
        }
        else if (columnType == "TIMESTAMP")
        {
            if (!(checkTIMESTAMP(currentValue)))
            {
                returnBool = false;
                errorColumnNames.push_back(la[intIterator]->text());
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

bool Insert::checkDATE(QString x)
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

bool Insert::checkNUMBER(QString x)
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

bool Insert::checkVARCHAR2(QString x)
{
    QRegExp re("[a-zA-Z0-9.,:;_-'() ]+");

    if(re.exactMatch(x))
        return true;

    return false;
}

bool Insert::checkCHAR(QString x)
{
    // fixed length ???

    QRegExp re("[a-zA-Z0-9.,:;_-'() ]+");

    if(re.exactMatch(x))
        return true;

    return false;
}

bool Insert::checkTIMESTAMP(QString x)
{
    return true;
}

QString Insert::getLabelStyle()
{
    return this->cs1;
}

QString Insert::getLineEditStyle()
{
    return this->cs2;
}

QString Insert::getPushButtonStyle()
{
    return this->cs3;
}

void Insert::setTableName(QString tableName)
{
    this->tableName = tableName;
}

QString Insert::getTableName()
{
    return this->tableName;
}

void Insert::insertData(QString tableName, std::vector<QString> oldDataVector)
{
    model2 = new QSqlQueryModel();
    formLayout = new QFormLayout();
    button = new QPushButton("Dodaj");
    buttonExit = new QPushButton("Wyjdź");
    QSqlQuery columnsNames;
    QString x,y;
    int it = 0;
    int ax=10,ay=10;
    int ax2=220,ay2=13;

    for(auto &&leItem : le)   { delete leItem; leItem = NULL; }
    le.clear();
    for(auto &&laItem : la)   { delete laItem; laItem = NULL; }
    la.clear();

    newRows.clear();

    columnsNames.prepare
            ("select COLUMN_NAME,data_type from ALL_TAB_COLUMNS where TABLE_NAME='"
            +tableName.toUpper()+"'");
    if(columnsNames.exec())
    {
        model2->setQuery(columnsNames);
        ui->tableView->setModel(model2);
        ui->tableView->setVisible(0);
    }

    int row = model2->rowCount();
    for(int i=0; i<row; ++i)
    {
         x = ui->tableView->model()->
                 data(ui->tableView->model()->index(i,0)).toString();
         y = ui->tableView->model()->
                  data(ui->tableView->model()->index(i,1)).toString();
        newRows.emplace_back(std::pair<QString,QString>(x,y));
    }

    if (oldDataVector.empty())
    {
        for(auto &&t : newRows)
        {
            la.append(new QLabel(this));
            la[it]->setText(t.first);
            la[it]->setGeometry(ax,ay,300,30);
            la[it]->resize(300,30);
            la[it]->show();
            la[it]->setStyleSheet(this->getLabelStyle());
            ay += 30;

            le.append(new QLineEdit(this));
            le[it]->setGeometry(ax2,ay2,200,25);
            le[it]->resize(200,25);
            le[it]->show();
            le[it]->setStyleSheet(this->getLineEditStyle());
            ay2 += 30;

            formLayout->addRow(la[it], le[it]);

            it += 1;
        }
    }
    else
    {
        for(auto &&t : newRows)
        {
            la.append(new QLabel(this));
            la[it]->setText(t.first);
            la[it]->setGeometry(ax,ay,300,30);
            la[it]->resize(300,30);
            la[it]->show();
            la[it]->setStyleSheet(this->getLabelStyle());
            ay += 30;

            le.append(new QLineEdit(this));
            le[it]->setGeometry(ax2,ay2,200,25);
            le[it]->resize(200,25);
            le[it]->setText(oldDataVector[it]);
            le[it]->show();
            le[it]->setStyleSheet(this->getLineEditStyle());
            ay2 += 30;

            formLayout->addRow(la[it], le[it]);

            it += 1;
        }
    }

    button->setStyleSheet(this->getPushButtonStyle());
    buttonExit->setStyleSheet(this->getPushButtonStyle());
    connect(button, SIGNAL(clicked()), this, SLOT(addClicked()));
    connect(buttonExit, SIGNAL(clicked()), this, SLOT(buttonExitAction()));
    formLayout->addWidget(button);
    formLayout->addWidget(buttonExit);
    setLayout(formLayout);
}

void Insert::buttonExitAction()
{
    Insert::close();
}

Insert::~Insert()
{
    delete formLayout;
    formLayout = NULL;
    delete button;
    button = NULL;
    delete model2;
    model2 = NULL;
    delete newInsert;
    newInsert = NULL;

    for(auto &&leItem : le)   { delete leItem; leItem = NULL; }
    le.clear();
    for(auto &&laItem : la)   { delete laItem; laItem = NULL; }
    la.clear();

    delete ui;
}

void Insert::addClicked()
{
    QSqlQuery insertQuery;
    QString tableName = getTableName(), dateFormat = getDateFormat(), errorColumns;
    QString query = "INSERT INTO " + tableName +" (";
    bool status = std::get<0>(validation());
    typedef std::vector<QString> errorsV;
        errorsV columnsError = std::get<1>(validation());
        errorsV columnsError2 = uniqueVector(columnsError);
    QMessageBox msgInfo(
                QMessageBox::Information,
                "Status operacji",
                "Dodano rekord.",
                QMessageBox::Ok);
    QMessageBox msgCritical(
                QMessageBox::Critical,
                "Status operacji",
                "Wystąpił błąd. Nie dodano rekordu.\n",
                QMessageBox::Cancel);
    std::vector<QString> oldDataVector;


    for (int p = 0; p < le.size(); ++p)
        oldDataVector.emplace_back(le[p]->text());

    msgCritical.setButtonText(QMessageBox::Cancel, "Wyjdź");

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
                    "Wystąpił błąd. Nie dodano rekordu.\n"
                    "Poprawy wymagają wpisane wartości w kolumnach: \n"
                    + errorColumns.mid(0,errorColumns.size()-2),
                    QMessageBox::Cancel);
        msgCritical2.setButtonText(QMessageBox::Cancel, "Wyjdź");

        qInfo() << "Validation ERROR";
        msgCritical2.exec();

        newInsert = new Insert;
        newInsert->setWindowTitle("Dodaj rekord do tabeli " + tableName);
        newInsert->show();
        newInsert->setTableName(tableName);
        newInsert->setDateFormat("YYYY-MM-DD");
        newInsert->insertData(tableName,oldDataVector);

        Insert::close();

        return;
    }

    for(int c = 0; c < la.size(); ++c)
    {
        query += la[c]->text();
        query += ", ";
    }

    query = query.mid(0,query.size()-2);
    query += ") VALUES (";

    for(int s = 0; s < le.size(); ++s)
    {
        if(newRows[s].second == "NUMBER")
        {
            query += le[s]->text();
            query += ", ";
        }
        else if(newRows[s].second == "DATE")
        {
            query += "to_date('";
            query += le[s]->text();
            query += "','";
            query += dateFormat;
            query += "'), ";
        }
        else
        {
            query += "'";
            query += le[s]->text();
            query += "'";
            query += ", ";
        }
    }

    QString subString = query.mid(0,query.size()-2);

    subString += ')';

    insertQuery.prepare(subString);

    if (insertQuery.exec())
    {
        msgInfo.exec();
        QSqlDatabase::database().commit();
    }
    else
    {
        msgCritical.exec();

        newInsert = new Insert;
        newInsert->setWindowTitle("Dodaj rekord do tabeli " + tableName);
        newInsert->show();
        newInsert->setTableName(tableName);
        newInsert->setDateFormat("YYYY-MM-DD");
        newInsert->insertData(tableName,oldDataVector);
    }

    Insert::close();
}
