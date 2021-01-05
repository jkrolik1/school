#ifndef USERCOMMAND_H
#define USERCOMMAND_H

#include <QDialog>
#include <QFormLayout>
#include <QLabel>
#include <QLineEdit>
#include <QSqlQueryModel>
#include <QTableView>

namespace Ui {
class UserCommand;
}

class UserCommand : public QDialog
{
    Q_OBJECT

public:
    explicit UserCommand(QWidget *parent = nullptr);
    void doQuery(QString);
    QString getPushButtonStyle();
    QString getLabelStyle();
    QString getLineEditStyle();
    QString getCommand();
    void setCommand(QString);
    void implSELECT();
    ~UserCommand();

private slots:
    void userQueryRealization();
    void userCommandClose();

private:
    Ui::UserCommand *ui;
    QFormLayout *formLayout = nullptr;
    QPushButton *button = nullptr, *buttonExit = nullptr;
    QLabel *title = nullptr;
    QSqlQueryModel *model = nullptr;
    QTableView *resulfOfSELECT = nullptr;
    QString command;
    QString cs1="QLabel {"
                "font-size: 17px;"
                "color: rgb(220,220,220);"
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

#endif // USERCOMMAND_H
