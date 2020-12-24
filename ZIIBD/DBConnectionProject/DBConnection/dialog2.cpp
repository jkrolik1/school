#include "dialog2.h"
#include "ui_dialog2.h"
#include "connection.h"

#include <QSqlDatabase>
#include <QSqlQueryModel>

Dialog2::Dialog2(QWidget *parent) :
    QDialog(parent),
    ui(new Ui::Dialog2)
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
    ui->pushButton_2->setStyleSheet(cs1);
    ui->pushButton_3->setStyleSheet(cs1);
    ui->pushButton_4->setStyleSheet(cs1);
}

void Dialog2::TableManager(QString x)
{
    QSqlQueryModel *model = new QSqlQueryModel();

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
    delete ui;
}

void Dialog2::on_pushButton_4_clicked()
{
    Dialog2::close();
}
