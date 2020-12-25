#ifndef INSERT_H
#define INSERT_H

#include <QDialog>

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
    ~Insert();

private slots:
    void on_pushButton_clicked();

private:
    std::unordered_map<QString,QString> newRows;
    Ui::Insert *ui;
};

#endif // INSERT_H
