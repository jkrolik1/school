#ifndef CHOSEFORUPDATE_H
#define CHOSEFORUPDATE_H

#include <QDialog>
#include <QSqlQueryModel>
#include <queries/updatetable.h>

namespace Ui {
class choseForUpdate;
}

class choseForUpdate : public QDialog
{
    Q_OBJECT

public:
    explicit choseForUpdate(QWidget *parent = nullptr);
    ~choseForUpdate();
    void setTableName(QString);
    QString getTableName();
    void choseLine();

private slots:
    void on_tableView_doubleClicked(const QModelIndex &index);

private:
    QSqlQueryModel *model = nullptr;
    updateTable *updateX = nullptr;
    QString tableName;
    Ui::choseForUpdate *ui;
};

#endif // CHOSEFORUPDATE_H
