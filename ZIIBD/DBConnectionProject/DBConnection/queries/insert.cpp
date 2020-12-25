#include "insert.h"
#include "ui_insert.h"
#include "connection.h"

#include <QSqlDatabase>
#include <QSqlQueryModel>
#include <unordered_map>

QVector<QLabel*> la;
QVector<QLineEdit*> le;

Insert::Insert(QWidget *parent) :
    QDialog(parent),
    ui(new Ui::Insert)
{
    ui->setupUi(this);

    QString cs1="QPushButton {"
                    "font-size: 15px;"
                    "background-color: rgb(128,128,128);"
                    "color: white;"
                "}"
                 "QPushButton:hover {"
                    "background-color: white;"
                    "color: black;"
                 "}";
    ui->pushButton->setStyleSheet(cs1);

    ui->lineEdit_2->setVisible(0);
    ui->label->setVisible(0);
    ui->lineEdit->setVisible(0);
}

QString Insert::getLabelStyle()
{
    return this->cs1;
}

QString Insert::getLineEditStyle()
{
    return this->cs2;
}

void Insert::setTableName(QString tableName)
{
    this->tableName = tableName;
}

QString Insert::getTableName()
{
    return this->tableName;
}

void Insert::insertData(QString tableName)
{
    QSqlQueryModel *model2 = new QSqlQueryModel();
    QSqlQuery columnsNames;
    QString x;
    int it = 0;
    int ax=10,ay=10;
    int ax2=220,ay2=13;

    columnsNames.prepare
            ("select COLUMN_NAME from ALL_TAB_COLUMNS where TABLE_NAME='"
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
        newRows.insert(std::pair<QString,QString>(x,""));
    }

    for(auto t : newRows)
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

        it += 1;
    }
}

Insert::~Insert()
{
    delete ui;
}

void Insert::on_pushButton_clicked()
{
    QSqlQuery insertQuery;
    QString tableName = getTableName();
    QString query = "INSERT INTO " + tableName +" (";

    for(int c = 0; c < la.size(); ++c)
    {
        query += la[c]->text();
        query += ", ";
    }

    query = query.mid(0,query.size()-2);
    query += ") VALUES (";

    for(int s = 0; s < la.size(); ++s)
        query += "?, ";

    QString subString = query.mid(0,query.size()-2);

    subString += ')';

    insertQuery.prepare(subString);

    for(int h = 0; h < la.size(); ++h)
        insertQuery.addBindValue(le[h]->text());

    insertQuery.exec();

    QSqlDatabase::database().commit();

    le.clear();
    la.clear();

    Insert::close();
}
