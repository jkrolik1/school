#include "dialog.h"
#include "ui_dialog.h"
#include <QSqlDatabase>
#include "connection.h"

#include <QSqlQueryModel>

Dialog::Dialog(QWidget *parent)
    : QDialog(parent)
    , ui(new Ui::Dialog)
{
    ui->setupUi(this);

    Connection c;
    bool ok = c.create_connection();

    QSqlQueryModel *model = new QSqlQueryModel();

    if(ok)
    {
        QSqlQuery q;
        q.prepare("SELECT table_name as \"Tabele w bazie\" FROM user_tables");
        if(q.exec())
        {
            model->setQuery(q);
            ui->tableView->setModel(model);
        }

    }
    else
    {
        delete model;
    }
}

Dialog::~Dialog()
{
    delete ui;
}

void Dialog::on_pushButton_clicked()
{
    Dialog::close();
}
