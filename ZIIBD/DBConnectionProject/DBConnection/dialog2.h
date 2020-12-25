#ifndef DIALOG2_H
#define DIALOG2_H

#include <QDialog>
#include <QSqlDatabase>

namespace Ui {
class Dialog2;
}

class Dialog2 : public QDialog
{
    Q_OBJECT

public:
    explicit Dialog2(QWidget *parent = nullptr);
    void TableManager(QString);
    void setTableName(QString);
    QString getTableName();
    ~Dialog2();

private slots:
    void on_pushButton_4_clicked();

    void on_pushButton_clicked();

    void on_pushButton_3_clicked();

    void on_pushButton_2_clicked();

private:
    QString tableName;
    Ui::Dialog2 *ui;
};

#endif // DIALOG2_H
