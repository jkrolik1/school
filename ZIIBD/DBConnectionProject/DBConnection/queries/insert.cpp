#include "insert.h"
#include "ui_insert.h"
#include "connection.h"

#include <QSqlDatabase>
#include <QSqlQueryModel>
#include <unordered_map>

Insert::Insert(QWidget *parent) :
    QDialog(parent),
    ui(new Ui::Insert)
{
    ui->setupUi(this);
}

void Insert::insertData(QString tableName)
{
    QSqlQueryModel *model2 = new QSqlQueryModel();
    QSqlQuery columnsNames;
    QString x;

    columnsNames.prepare
            ("select COLUMN_NAME from ALL_TAB_COLUMNS where TABLE_NAME='"
            +tableName.toUpper()+"'");
    if(columnsNames.exec())
    {
        model2->setQuery(columnsNames);
        ui->tableView->setModel(model2);
        ui->tableView->setVisible(0);
    }

    int row = model2->rowCount();
    for(int i=0; i<row; ++i)
    {
         x = ui->tableView->model()->
                 data(ui->tableView->model()->index(i,0)).toString();
        newRows.insert(std::pair<QString,QString>(x,""));
    }

    for(auto c : newRows)
    {
        ui->label->setText(c.first);


        ui->lineEdit_2->setText(newRows[c.second]);

        break;
    }
}

Insert::~Insert()
{
    delete ui;
}

void Insert::on_pushButton_clicked()
{
    if (ui->lineEdit->text() != "")
    {
        newRows[0] = ui->lineEdit->text();
    }

    ui->lineEdit_2->setText(newRows[0]);
}
