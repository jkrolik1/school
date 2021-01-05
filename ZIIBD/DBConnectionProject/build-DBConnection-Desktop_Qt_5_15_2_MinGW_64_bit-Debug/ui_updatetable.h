/********************************************************************************
** Form generated from reading UI file 'updatetable.ui'
**
** Created by: Qt User Interface Compiler version 5.15.2
**
** WARNING! All changes made in this file will be lost when recompiling UI file!
********************************************************************************/

#ifndef UI_UPDATETABLE_H
#define UI_UPDATETABLE_H

#include <QtCore/QVariant>
#include <QtWidgets/QApplication>
#include <QtWidgets/QDialog>
#include <QtWidgets/QHeaderView>
#include <QtWidgets/QLabel>
#include <QtWidgets/QLineEdit>
#include <QtWidgets/QTableView>

QT_BEGIN_NAMESPACE

class Ui_updateTable
{
public:
    QTableView *tableView;
    QLineEdit *lineEdit;
    QLabel *label;
    QTableView *tableView_2;
    QTableView *tableView_3;
    QLineEdit *lineEdit_2;

    void setupUi(QDialog *updateTable)
    {
        if (updateTable->objectName().isEmpty())
            updateTable->setObjectName(QString::fromUtf8("updateTable"));
        updateTable->resize(431, 95);
        updateTable->setStyleSheet(QString::fromUtf8("background-color: rgb(64,64,64);"));
        tableView = new QTableView(updateTable);
        tableView->setObjectName(QString::fromUtf8("tableView"));
        tableView->setEnabled(true);
        tableView->setGeometry(QRect(340, 61, 21, 20));
        lineEdit = new QLineEdit(updateTable);
        lineEdit->setObjectName(QString::fromUtf8("lineEdit"));
        lineEdit->setGeometry(QRect(110, 20, 113, 21));
        label = new QLabel(updateTable);
        label->setObjectName(QString::fromUtf8("label"));
        label->setGeometry(QRect(20, 30, 141, 16));
        label->setStyleSheet(QString::fromUtf8("font-size: 14px;\n"
"color: rgb(220,220,220);"));
        tableView_2 = new QTableView(updateTable);
        tableView_2->setObjectName(QString::fromUtf8("tableView_2"));
        tableView_2->setGeometry(QRect(290, 60, 41, 20));
        tableView_3 = new QTableView(updateTable);
        tableView_3->setObjectName(QString::fromUtf8("tableView_3"));
        tableView_3->setGeometry(QRect(370, 60, 51, 21));
        lineEdit_2 = new QLineEdit(updateTable);
        lineEdit_2->setObjectName(QString::fromUtf8("lineEdit_2"));
        lineEdit_2->setGeometry(QRect(10, 60, 231, 21));

        retranslateUi(updateTable);

        QMetaObject::connectSlotsByName(updateTable);
    } // setupUi

    void retranslateUi(QDialog *updateTable)
    {
        updateTable->setWindowTitle(QCoreApplication::translate("updateTable", "Dialog", nullptr));
        label->setText(QCoreApplication::translate("updateTable", "TextLabel", nullptr));
    } // retranslateUi

};

namespace Ui {
    class updateTable: public Ui_updateTable {};
} // namespace Ui

QT_END_NAMESPACE

#endif // UI_UPDATETABLE_H
