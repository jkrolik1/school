#include "dialog.h"
#include "ui_dialog.h"
#include <QSqlDatabase>

Dialog::Dialog(QWidget *parent)
    : QDialog(parent)
    , ui(new Ui::Dialog)
{
    ui->setupUi(this);

    QSqlDatabase db = QSqlDatabase::addDatabase("QOCI");
    db.setHostName("155.158.112.45");
    db.setDatabaseName("ziibd19");
    db.setUserName("ziibd19");
    db.setPassword("haslo1");
    bool ok = db.open();
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

