#include "choseforupdate.h"
#include "ui_choseforupdate.h"
#include "connection.h"

#include "queries/updatetable.h"

#include <QSqlDatabase>
#include <QSqlQueryModel>


choseForUpdate::choseForUpdate(QWidget *parent) :
    QDialog(parent),
    ui(new Ui::choseForUpdate)
{
    ui->setupUi(this);
}

void choseForUpdate::choseLine()
{
    model = new QSqlQueryModel();

    QSqlQuery q;
    q.prepare("SELECT * FROM " + getTableName());
    if(q.exec())
    {
        model->setQuery(q);
        ui->tableView->setModel(model);
        ui->tableView->horizontalHeader()->setSectionResizeMode
                (QHeaderView::Stretch);
    }
}

void choseForUpdate::setTableName(QString tableName)
{
    this->tableName = tableName;
}

QString choseForUpdate::getTableName()
{
    return this->tableName;
}

choseForUpdate::~choseForUpdate()
{
    delete model;
    delete updateX;
    delete ui;

    model = NULL;
    updateX = NULL;
}

void choseForUpdate::on_tableView_doubleClicked(const QModelIndex &index)
{
    updateX = new updateTable;
    QString tableName = getTableName();

    updateX->setTableName(tableName);
    updateX->setWindowTitle("Zmień w tabeli " + tableName);

    int row = index.row();
    QString x =
            ui->tableView->model()->data
            (ui->tableView->model()->index(row,0)).toString();

    updateX->updateData(index, x);
    updateX->show();

    choseForUpdate::close();
}
