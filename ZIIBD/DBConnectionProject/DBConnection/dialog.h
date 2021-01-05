#ifndef DIALOG_H
#define DIALOG_H

#include <QDialog>
#include <dialog2.h>
#include <QSqlQueryModel>
#include <queries/usercommand.h>

QT_BEGIN_NAMESPACE
namespace Ui { class Dialog; }
QT_END_NAMESPACE

class Dialog : public QDialog
{
    Q_OBJECT

public:
    Dialog(QWidget *parent = nullptr);
    ~Dialog();

private slots:
    void on_pushButton_clicked();

    void on_tableView_doubleClicked(const QModelIndex &index);

    void on_pushButton_2_clicked();

private:
    QSqlQueryModel *model = nullptr;
    Dialog2 *subDialog = nullptr;
    UserCommand *userQuery = nullptr;
    Ui::Dialog *ui;
};
#endif // DIALOG_H
