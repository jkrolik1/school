#ifndef UPDATETABLE_H
#define UPDATETABLE_H

#include <QDialog>

#include <unordered_map>
#include <QLabel>
#include <QLineEdit>
#include <QSqlQueryModel>
#include <QFormLayout>

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
    bool updateData(QString);
    QString getLabelStyle();
    QString getLineEditStyle();
    void setDateFormat(QString);
    QString getDateFormat();
    QString getPushButtonStyle();
    ~updateTable();

private slots:
    void updateClicked();

private:
    std::unordered_map<QString,QString> newRows;
    Ui::updateTable *ui;
    QString tableName, dateFormat;
    QString cs1="QLabel {"
                "font-size: 15px;"
                "color: rgb(220,220,220);"
                "margin-right: 7px;"
                "}";
    QString cs2="QLineEdit {"
                "font-size: 13px;"
                "color: rgb(220,220,220);"
                "}";
    QString cs3="QPushButton {"
                    "font-size: 15px;"
                    "background-color: rgb(128,128,128);"
                    "color: white;"
                "}"
                 "QPushButton:hover {"
                    "background-color: white;"
                    "color: black;"
                 "}";
};

#endif // UPDATETABLE_H
