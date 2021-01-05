/********************************************************************************
** Form generated from reading UI file 'insert.ui'
**
** Created by: Qt User Interface Compiler version 5.15.2
**
** WARNING! All changes made in this file will be lost when recompiling UI file!
********************************************************************************/

#ifndef UI_INSERT_H
#define UI_INSERT_H

#include <QtCore/QVariant>
#include <QtWidgets/QApplication>
#include <QtWidgets/QDialog>
#include <QtWidgets/QHeaderView>
#include <QtWidgets/QLabel>
#include <QtWidgets/QLineEdit>
#include <QtWidgets/QTableView>

QT_BEGIN_NAMESPACE

class Ui_Insert
{
public:
    QTableView *tableView;
    QLabel *label;
    QLineEdit *lineEdit;

    void setupUi(QDialog *Insert)
    {
        if (Insert->objectName().isEmpty())
            Insert->setObjectName(QString::fromUtf8("Insert"));
        Insert->resize(430, 47);
        Insert->setStyleSheet(QString::fromUtf8("background-color: rgb(64,64,64);"));
        tableView = new QTableView(Insert);
        tableView->setObjectName(QString::fromUtf8("tableView"));
        tableView->setEnabled(true);
        tableView->setGeometry(QRect(330, 10, 41, 21));
        label = new QLabel(Insert);
        label->setObjectName(QString::fromUtf8("label"));
        label->setGeometry(QRect(10, 10, 141, 16));
        label->setStyleSheet(QString::fromUtf8("font-size: 14px;\n"
"color: rgb(220,220,220);"));
        lineEdit = new QLineEdit(Insert);
        lineEdit->setObjectName(QString::fromUtf8("lineEdit"));
        lineEdit->setGeometry(QRect(160, 10, 113, 21));

        retranslateUi(Insert);

        QMetaObject::connectSlotsByName(Insert);
    } // setupUi

    void retranslateUi(QDialog *Insert)
    {
        Insert->setWindowTitle(QCoreApplication::translate("Insert", "Dialog", nullptr));
        label->setText(QCoreApplication::translate("Insert", "TextLabel", nullptr));
    } // retranslateUi

};

namespace Ui {
    class Insert: public Ui_Insert {};
} // namespace Ui

QT_END_NAMESPACE

#endif // UI_INSERT_H
