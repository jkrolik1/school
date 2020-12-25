#include "deletefrom.h"
#include "ui_deletefrom.h"
#include "connection.h"

#include <QSqlDatabase>
#include <QSqlQueryModel>

deleteFrom::deleteFrom(QWidget *parent) :
    QDialog(parent),
    ui(new Ui::deleteFrom)
{
    ui->setupUi(this);
}

void deleteFrom::deleteData()
{
    QSqlQueryModel *model3 = new QSqlQueryModel();
    QSqlQuery tableViewForDel;
    QString tableName = getTableName();

    tableViewForDel.prepare("SELECT * FROM " + tableName);
    if(tableViewForDel.exec())
    {
        model3->setQuery(tableViewForDel);
        ui->tableView->setModel(model3);
        ui->tableView->horizontalHeader()->setSectionResizeMode
                (QHeaderView::Stretch);
    }

}

void deleteFrom::setTableName(QString tableName)
{
    this->tableName = tableName;
}

QString deleteFrom::getTableName()
{
    return this->tableName;
}

deleteFrom::~deleteFrom()
{
    delete ui;
}

void deleteFrom::on_tableView_doubleClicked(const QModelIndex &index)
{
    ui->tableView_2->resize(0,0);

    int row = index.row();
    QString y =
            ui->tableView->model()->data
            (ui->tableView->model()->index(row,0)).toString();
    QSqlQueryModel *model5 = new QSqlQueryModel();
    QSqlQuery delQ;
    QString tableName = getTableName();
    QString h;
    QSqlQuery columnName0;

    columnName0.prepare
            ("select COLUMN_NAME from ALL_TAB_COLUMNS where TABLE_NAME='"
            +tableName.toUpper()+"'");
    if(columnName0.exec())
    {
        model5->setQuery(columnName0);
        ui->tableView_2->setModel(model5);
        ui->tableView_2->setVisible(0);
        QModelIndex newIndex = ui->tableView_2->model()->index(0,0);
        int row2 = newIndex.row();
        int col2 = newIndex.column();
        h = ui->tableView_2->model()->data
                (ui->tableView_2->model()->index(row2,col2)).toString();
    }

    delQ.prepare
            ("DELETE FROM " + tableName + " WHERE " + h + " = ?");
    delQ.addBindValue(y);

    delQ.exec();


}
