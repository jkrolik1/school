#include "dialog.h"
#include "ui_dialog.h"
#include <QSqlDatabase>
#include "connection.h"

Dialog::Dialog(QWidget *parent)
    : QDialog(parent)
    , ui(new Ui::Dialog)
{
    ui->setupUi(this);

    Connection c;
    bool ok = c.create_connection();

    if(ok)
    {
        ui->textEdit->setText("Dobrze");
    }
    else
    {
        ui->textEdit->setText("Zle");
    }

}

Dialog::~Dialog()
{
    delete ui;
}

