#include "updatetable.h"
#include "ui_updatetable.h"
#include "connection.h"

#include <QSqlDatabase>
#include <QSqlQueryModel>
#include <unordered_map>
#include <QMessageBox>

QVector<QLabel*> la2;
QVector<QLineEdit*> le2;
QString foreQ = "";

updateTable::updateTable(QWidget *parent) :
    QDialog(parent),
    ui(new Ui::updateTable)
{
    ui->setupUi(this);
    ui->tableView->setVisible(0);
    ui->tableView_2->setVisible(0);
    ui->tableView_3->setVisible(0);
    ui->label->setVisible(0);
    ui->lineEdit->setVisible(0);
    ui->lineEdit_2->setVisible(0);
}

void updateTable::updateData(const QModelIndex &index, QString name)
{
    QSqlQueryModel *model7 = new QSqlQueryModel();
    QSqlQuery columnsNames, values, columnName0;
    QString x, columnName = "", iValue = "", myQuery, columnName0Q;
    int it = 0;
    int ax=10,ay=10;
    int ax2=220,ay2=13;
    int row;
    QRegExp re("\\d*");

    le2.clear();
    la2.clear();
    newRows.clear();

    columnName0Q = "select COLUMN_NAME from ALL_TAB_COLUMNS where TABLE_NAME='"
            +tableName.toUpper()+"'";
    columnName0.prepare(columnName0Q);

    if(columnName0.exec())
    {
        model7->setQuery(columnName0);
        ui->tableView->setModel(model7);
        QModelIndex newIndex = ui->tableView->model()->index(0,0);
        int row2 = newIndex.row();
        int col2 = newIndex.column();
        columnName = ui->tableView->model()->data
                (ui->tableView->model()->index(row2,col2)).toString();
    }

    row = model7->rowCount();
    for(int i=0; i<row; ++i)
    {
        x = ui->tableView->model()->
                 data(ui->tableView->model()->index(i,0)).toString();
        newRows.insert(std::pair<QString,QString>(x,""));
    }

    for(auto t : newRows)
    {
        QSqlQueryModel *model8 = new QSqlQueryModel();
        myQuery = ("select " + t.first + " from " + getTableName() +
                   " where " + columnName + " = '" + name + "'");
        values.prepare(myQuery);

        if(values.exec())
        {
            model8->setQuery(values);
            ui->tableView->setModel(model8);

            QModelIndex newIndex = ui->tableView->model()->index(0,0);
            int row2 = newIndex.row();
            int col2 = newIndex.column();
            iValue = ui->tableView->model()->data
                    (ui->tableView->model()->index(row2,col2)).toString();
        }

        la2.append(new QLabel(this));
        la2[it]->setText(t.first);
        la2[it]->setGeometry(ax,ay,300,30);
        la2[it]->resize(300,30);
        la2[it]->show();
        la2[it]->setStyleSheet(this->getLabelStyle());
        ay += 30;

        le2.append(new QLineEdit(this));
        le2[it]->setGeometry(ax2,ay2,200,25);
        le2[it]->resize(200,25);
        le2[it]->setText(iValue);
        le2[it]->show();
        le2[it]->setStyleSheet(this->getLineEditStyle());
        ay2 += 30;

        it += 1;

        delete model8;
    }

    if(re.exactMatch(name))
        foreQ = " where " + columnName + " = " + name;
    else
        foreQ = " where " + columnName + " = '" + name + "'";
}

QString updateTable::getLabelStyle()
{
    return this->cs1;
}

QString updateTable::getLineEditStyle()
{
    return this->cs2;
}

void updateTable::setTableName(QString tableName)
{
    this->tableName = tableName;
}

QString updateTable::getTableName()
{
    return this->tableName;
}

updateTable::~updateTable()
{
    delete ui;
}

void updateTable::on_pushButton_clicked()
{
    QSqlQuery updateQuery;
    QString tableName = getTableName(), query;
    QRegExp re("\\d*");

    query = "UPDATE " + getTableName() + " SET ";

    //QSqlQuery q;
    //q.prepare("alter table " + getTableName() + " disable foreign key cascade;");
    //q.exec();

    for(int c = 0; c < la2.size(); ++c)
    {
        if(re.exactMatch(le2[c]->text()))
        {
            query += "\"";
            query += la2[c]->text();
            query += "\" = ?, ";
        }
        else
        {
            query += "\"";
            query += la2[c]->text();
            query += "\" = '?', ";
        }
    }

    query = query.mid(0,query.size()-2);
    query += foreQ;

    updateQuery.prepare(query);

    for(int c = 0; c < le2.size(); ++c)
    {
        updateQuery.addBindValue(le2[c]->text());
    }

    QMessageBox msgBox(
                QMessageBox::Question,
                "Potwierdzenie usunięcia rekordu",
                query,
                QMessageBox::Yes | QMessageBox::No);

    msgBox.exec();

    updateQuery.exec();

    QSqlDatabase::database().commit();

    updateTable::close();
}
