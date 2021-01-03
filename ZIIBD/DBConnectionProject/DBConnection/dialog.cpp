#include "dialog.h"
#include "ui_dialog.h"
#include "dialog2.h"
#include "ui_dialog2.h"
#include "queries/usercommand.h"

#include <QSqlDatabase>
#include "connection.h"
#include <QSqlQueryModel>
#include <QStandardItemModel>

#include <memory>


Dialog::Dialog(QWidget *parent)
    : QDialog(parent)
    , ui(new Ui::Dialog)
{
    ui->setupUi(this);

    // Frameless
    //setWindowFlags(Qt::Dialog | Qt::FramelessWindowHint | Qt::CustomizeWindowHint);
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

    Connection c;
    bool ok = c.create_connection();

    model = new QSqlQueryModel();

    if(ok)
    {
        QSqlQuery q;
        q.prepare("SELECT table_name as \"Tabele w bazie\" FROM user_tables");
        if(q.exec())
        {
            model->setQuery(q);
            ui->tableView->setModel(model);
            ui->tableView->setColumnWidth(0,230);
            ui->tableView->horizontalHeader()->setSectionResizeMode
                    (QHeaderView::Stretch);
        }
    }
    else
    {
        delete model;
    }
}

Dialog::~Dialog()
{
    delete subDialog;
    delete model;
    delete ui;

    subDialog = NULL;
    model = NULL;
}

void Dialog::on_pushButton_clicked()
{
    Dialog::close();
}

void Dialog::on_tableView_doubleClicked(const QModelIndex &index)
{
    subDialog = new Dialog2;
    int row = index.row();
    QString x =
            ui->tableView->model()->data
            (ui->tableView->model()->index(row,0)).toString();

    subDialog->setWindowTitle("Tabela " + x);
    subDialog->show();

    subDialog->TableManager(x);
    subDialog->setTableName(x);
}

void Dialog::on_pushButton_2_clicked()
{
    userQuery = new UserCommand;
    userQuery->setWindowTitle("Wpisz swoje polecenie do bazy");
    userQuery->doQuery();
    userQuery->show();
}
