#ifndef UPDATETABLE_H
#define UPDATETABLE_H

#include <QDialog>

#include <unordered_map>

namespace Ui {
class updateTable;
}

class updateTable : public QDialog
{
    Q_OBJECT

public:
    explicit updateTable(QWidget *parent = nullptr);
    void setTableName(QString);
    QString getTableName();
    void updateData(const QModelIndex &, QString);
    QString getLabelStyle();
    QString getLineEditStyle();
    ~updateTable();

private slots:
    void on_pushButton_clicked();

private:
    std::unordered_map<QString,QString> newRows;
    Ui::updateTable *ui;
    QString tableName;
    QString cs1="QLabel {"
                "font-size: 15px;"
                "color: rgb(220,220,220);"
                "}";
    QString cs2="QLineEdit {"
                "font-size: 13px;"
                "color: rgb(220,220,220);"
                "}";
};

#endif // UPDATETABLE_H
