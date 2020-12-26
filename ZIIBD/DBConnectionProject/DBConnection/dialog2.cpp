#include "dialog2.h"
#include "ui_dialog2.h"
#include "connection.h"

#include "queries/insert.h"
#include "queries/deletefrom.h"
#include "queries/updatetable.h"
#include "queries/choseforupdate.h"

#include <QSqlDatabase>
#include <QSqlQueryModel>


Dialog2::Dialog2(QWidget *parent) :
    QDialog(parent),
    ui(new Ui::Dialog2)
{
    ui->setupUi(this);

    setWindowFlags(Qt::WindowMinimizeButtonHint |
                   Qt::WindowMaximizeButtonHint |
                   Qt::WindowCloseButtonHint);

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
    ui->pushButton_2->setStyleSheet(cs1);
    ui->pushButton_3->setStyleSheet(cs1);
    ui->pushButton_4->setStyleSheet(cs1);
}

void Dialog2::setTableName(QString tableName)
{
    this->tableName = tableName;
}

QString Dialog2::getTableName()
{
    return this->tableName;
}

void Dialog2::TableManager(QString x)
{
    model = new QSqlQueryModel();

    QSqlQuery q;
    q.prepare("SELECT * FROM " + x);
    if(q.exec())
    {
        model->setQuery(q);
        ui->tableView->setModel(model);
        ui->tableView->horizontalHeader()->setSectionResizeMode
                (QHeaderView::Stretch);
    }
}

Dialog2::~Dialog2()
{
    delete cfu;
    delete deleteX;
    delete insertX;
    delete model;
    delete ui;

    cfu = NULL;
    deleteX = NULL;
    insertX = NULL;
    model = NULL;
}

void Dialog2::on_pushButton_4_clicked()
{
    Dialog2::close();
}

void Dialog2::on_pushButton_clicked()
{
    insertX = new Insert;
    QString tableName = getTableName();
    insertX->setWindowTitle("Dodaj rekord do tabeli " + tableName);
    insertX->show();
    insertX->setTableName(tableName);
    insertX->insertData(tableName);
    Dialog2::close();
}

void Dialog2::on_pushButton_3_clicked()
{
    deleteX = new deleteFrom;
    QString tableName = getTableName();
    deleteX->setWindowTitle("Usuń rekord z tabeli " + tableName);
    deleteX->show();
    deleteX->setTableName(tableName);
    deleteX->deleteData();
    Dialog2::close();
}

void Dialog2::on_pushButton_2_clicked()
{
    cfu = new choseForUpdate;
    QString tableName = getTableName();

    cfu->setTableName(tableName);

    cfu->setWindowTitle("Wybierz rekord do zmiany");

    cfu->choseLine();
    cfu->show();

    Dialog2::close();
}
