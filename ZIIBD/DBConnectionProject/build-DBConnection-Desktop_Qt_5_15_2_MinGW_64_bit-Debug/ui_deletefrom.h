/********************************************************************************
** Form generated from reading UI file 'deletefrom.ui'
**
** Created by: Qt User Interface Compiler version 5.15.2
**
** WARNING! All changes made in this file will be lost when recompiling UI file!
********************************************************************************/

#ifndef UI_DELETEFROM_H
#define UI_DELETEFROM_H

#include <QtCore/QVariant>
#include <QtWidgets/QApplication>
#include <QtWidgets/QDialog>
#include <QtWidgets/QFrame>
#include <QtWidgets/QGridLayout>
#include <QtWidgets/QHeaderView>
#include <QtWidgets/QLabel>
#include <QtWidgets/QLineEdit>
#include <QtWidgets/QSpacerItem>
#include <QtWidgets/QTableView>

QT_BEGIN_NAMESPACE

class Ui_deleteFrom
{
public:
    QGridLayout *gridLayout;
    QLabel *label_2;
    QTableView *tableView;
    QLineEdit *lineEdit;
    QFrame *line;
    QSpacerItem *horizontalSpacer;
    QTableView *tableView_2;

    void setupUi(QDialog *deleteFrom)
    {
        if (deleteFrom->objectName().isEmpty())
            deleteFrom->setObjectName(QString::fromUtf8("deleteFrom"));
        deleteFrom->resize(719, 610);
        deleteFrom->setStyleSheet(QString::fromUtf8("background-color: rgb(64,64,64);"));
        gridLayout = new QGridLayout(deleteFrom);
        gridLayout->setObjectName(QString::fromUtf8("gridLayout"));
        label_2 = new QLabel(deleteFrom);
        label_2->setObjectName(QString::fromUtf8("label_2"));
        label_2->setStyleSheet(QString::fromUtf8("font-size: 17px;\n"
"color: rgb(220,220,220);\n"
"letter-spacing: 1px;"));

        gridLayout->addWidget(label_2, 0, 0, 1, 1);

        tableView = new QTableView(deleteFrom);
        tableView->setObjectName(QString::fromUtf8("tableView"));
        tableView->setStyleSheet(QString::fromUtf8("background-color: 	rgb(192,192,192);\n"
""));

        gridLayout->addWidget(tableView, 5, 0, 1, 1);

        lineEdit = new QLineEdit(deleteFrom);
        lineEdit->setObjectName(QString::fromUtf8("lineEdit"));

        gridLayout->addWidget(lineEdit, 3, 0, 1, 1);

        line = new QFrame(deleteFrom);
        line->setObjectName(QString::fromUtf8("line"));
        line->setFrameShape(QFrame::HLine);
        line->setFrameShadow(QFrame::Sunken);

        gridLayout->addWidget(line, 1, 0, 1, 1);

        horizontalSpacer = new QSpacerItem(40, 20, QSizePolicy::Expanding, QSizePolicy::Minimum);

        gridLayout->addItem(horizontalSpacer, 2, 0, 1, 1);

        tableView_2 = new QTableView(deleteFrom);
        tableView_2->setObjectName(QString::fromUtf8("tableView_2"));

        gridLayout->addWidget(tableView_2, 4, 0, 1, 1);


        retranslateUi(deleteFrom);

        QMetaObject::connectSlotsByName(deleteFrom);
    } // setupUi

    void retranslateUi(QDialog *deleteFrom)
    {
        deleteFrom->setWindowTitle(QCoreApplication::translate("deleteFrom", "Dialog", nullptr));
        label_2->setText(QCoreApplication::translate("deleteFrom", "Dwukrotnie kliknij na nazwe pola danego rekordu aby go usun\304\205\304\207", nullptr));
    } // retranslateUi

};

namespace Ui {
    class deleteFrom: public Ui_deleteFrom {};
} // namespace Ui

QT_END_NAMESPACE

#endif // UI_DELETEFROM_H
