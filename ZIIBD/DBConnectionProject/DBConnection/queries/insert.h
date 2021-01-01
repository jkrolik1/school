#ifndef INSERT_H
#define INSERT_H

#include <QDialog>
#include <QSqlQueryModel>
#include <QLabel>
#include <QLineEdit>

#include <unordered_map>
#include <tuple>
#include <vector>

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
    std::tuple<bool,std::vector<QString>> validation();

    bool checkDATE(QString);
    bool checkNUMBER(QString);
    bool checkVARCHAR2(QString);
    bool checkCHAR(QString);
    bool checkTIMESTAMP(QString);

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
