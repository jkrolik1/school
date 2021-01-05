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
    setWindowFlags(Qt::WindowMinimizeButtonHint |
                   Qt::WindowMaximizeButtonHint |
                   Qt::WindowCloseButtonHint);
    ui->setupUi(this);
    ui->tableView_2->setVisible(0);
    ui->lineEdit->setVisible(0);
}

void deleteFrom::deleteData()
{
    model3 = new QSqlQueryModel();
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
    delete model3;
    delete model5;
    delete model6;
    delete ui;

    model3 = NULL;
    model5 = NULL;
    model6 = NULL;
}

void deleteFrom::on_tableView_doubleClicked(const QModelIndex &index)
{
    int row = index.row();
    QString tableName = getTableName(), columnID = "",
            deleteID = ui->tableView->model()->
                        data(ui->tableView->model()->index(row,0)).toString();
    QSqlQuery delQ, idQ;
    QMessageBox warnMessage,
                msgInfo(
                    QMessageBox::Information,
                    "Status operacji",
                    "Usunięto rekord.",
                    QMessageBox::Ok),
                msgCritical(
                    QMessageBox::Critical,
                    "Status operacji",
                    "Wystąpił błąd. Nie usunięto rekordu.\n",
                    QMessageBox::Cancel);
    model5 = new QSqlQueryModel();
    model6 = new QSqlQueryModel();

    msgCritical.setButtonText(QMessageBox::Cancel, "Wyjdź");

    columnID =  "SELECT cols.column_name "
                "FROM all_constraints cons, all_cons_columns cols "
                "WHERE cols.table_name = '" + tableName.toUpper() + "' "
                "AND cons.constraint_type = 'P' "
                "AND cons.constraint_name = cols.constraint_name "
                "AND cons.owner = cols.owner "
                "ORDER BY cols.table_name, cols.position";
    idQ.prepare(columnID);

    if(idQ.exec())
    {
        model6->setQuery(idQ);
        ui->tableView_2->setModel(model6);
        columnID =
                ui->tableView_2->model()->data
                (ui->tableView_2->model()->index(0,0)).toString();
    }

    delQ.prepare
            ("DELETE FROM " + tableName + " WHERE " + columnID + " = ?");
    delQ.addBindValue(deleteID);

    QMessageBox msgBox(
                QMessageBox::Question,
                "Potwierdzenie usunięcia rekordu",
                "Czy usunąć rekord, gdzie " + columnID + " = " + deleteID + "?",
                QMessageBox::Yes | QMessageBox::No);

    msgBox.setButtonText(QMessageBox::Yes, "Usuń");
    msgBox.setButtonText(QMessageBox::No, "Wyjdź");
    deleteFrom::setWindowOpacity(0.9);

    switch(msgBox.exec())
    {
        case QMessageBox::Yes:
            if (delQ.exec())
                msgInfo.exec();
            else
                msgCritical.exec();
        break;
        case QMessageBox::No:
        default:
        break;
    }

    deleteFrom::close();
}
