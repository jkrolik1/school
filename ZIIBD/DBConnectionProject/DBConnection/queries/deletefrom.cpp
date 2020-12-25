#include "deletefrom.h"
#include "ui_deletefrom.h"
#include "connection.h"

#include <QSqlDatabase>
#include <QSqlQueryModel>
#include <QMessageBox>

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
    int row = index.row();
    QSqlQueryModel *model5 = new QSqlQueryModel();
    QString tableName = getTableName(), columnName = "",
            deleteID = ui->tableView->model()->
                        data(ui->tableView->model()->index(row,0)).toString();
    QSqlQuery delQ, columnName0;
    QMessageBox warnMessage;

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
        columnName = ui->tableView_2->model()->data
                (ui->tableView_2->model()->index(row2,col2)).toString();
    }

    delQ.prepare
            ("DELETE FROM " + tableName + " WHERE " + columnName + " = ?");
    delQ.addBindValue(deleteID);

    QMessageBox msgBox(
                QMessageBox::Question,
                "Potwierdzenie usunięcia rekordu",
                "Czy usunąć rekord, gdzie " + columnName + " = " + deleteID + " ?",
                QMessageBox::Yes | QMessageBox::No);

    msgBox.setButtonText(QMessageBox::Yes, "Usuń");
    msgBox.setButtonText(QMessageBox::No, "Wyjdź");
    deleteFrom::setWindowOpacity(0.9);

    switch(msgBox.exec())
    {
        case QMessageBox::Yes:
            delQ.exec();
            deleteFrom::close();
        break;
        case QMessageBox::No:
            deleteFrom::close();
        break;
        default:
            deleteFrom::close();
        break;
    }
}
