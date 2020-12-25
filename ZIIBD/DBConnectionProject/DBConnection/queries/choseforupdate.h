#ifndef CHOSEFORUPDATE_H
#define CHOSEFORUPDATE_H

#include <QDialog>

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
    QString tableName;
    Ui::choseForUpdate *ui;
};

#endif // CHOSEFORUPDATE_H
