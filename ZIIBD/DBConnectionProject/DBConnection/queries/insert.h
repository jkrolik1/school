#ifndef INSERT_H
#define INSERT_H

#include <QDialog>
#include <QSqlQueryModel>
#include <QLabel>
#include <QLineEdit>

#include <unordered_map>

namespace Ui {
class Insert;
}

class Insert : public QDialog
{
    Q_OBJECT

public:
    explicit Insert(QWidget *parent = nullptr);
    void insertData(QString);
    QString getLabelStyle();
    QString getLineEditStyle();
    void setTableName(QString);
    QString getTableName();
    ~Insert();

private slots:
    void on_pushButton_clicked();

private:
    QVector<QLabel*> la;
    QVector<QLineEdit*> le;
    QSqlQueryModel *model2 = nullptr;
    QString tableName;
    QString cs1="QLabel {"
                "font-size: 15px;"
                "color: rgb(220,220,220);"
                "}";
    QString cs2="QLineEdit {"
                "font-size: 13px;"
                "color: rgb(220,220,220);"
                "}";
    std::unordered_map<QString,QString> newRows;
    Ui::Insert *ui;
};

#endif // INSERT_H
