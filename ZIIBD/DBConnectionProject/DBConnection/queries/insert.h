#ifndef INSERT_H
#define INSERT_H

#include <QDialog>
#include <QSqlQueryModel>
#include <QLabel>
#include <QLineEdit>
#include <QFormLayout>
#include <QPushButton>
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

    template<typename t>
    std::vector<t> uniqueVector(std::vector<t>&);

    QString getLabelStyle();
    QString getLineEditStyle();
    QString getPushButtonStyle();

    void setTableName(QString);
    QString getTableName();

    void setDateFormat(QString);
    QString getDateFormat();

    std::tuple<bool,std::vector<QString>> validation();

    bool checkDATE(QString);
    bool checkNUMBER(QString);
    bool checkVARCHAR2(QString);
    bool checkCHAR(QString);
    bool checkTIMESTAMP(QString);

    ~Insert();

private slots:
    void addClicked();

private:
    QVector<QLabel*> la;
    QVector<QLineEdit*> le;
    QSqlQueryModel *model2 = nullptr;
    QFormLayout *formLayout = nullptr;
    QPushButton *button = nullptr;
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
    std::unordered_map<QString,QString> newRows;
    Ui::Insert *ui;
};

#endif // INSERT_H
