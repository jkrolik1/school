#ifndef DELETEFROM_H
#define DELETEFROM_H

#include <QDialog>
#include <QSqlQueryModel>

namespace Ui {
class deleteFrom;
}

class deleteFrom : public QDialog
{
    Q_OBJECT

public:
    explicit deleteFrom(QWidget *parent = nullptr);
    void setTableName(QString);
    QString getTableName();
    void deleteData();
    ~deleteFrom();

private slots:
    void on_tableView_doubleClicked(const QModelIndex &index);

private:
    QSqlQueryModel *model3 = nullptr, *model5 = nullptr;
    QString tableName;
    Ui::deleteFrom *ui;
};

#endif // DELETEFROM_H
