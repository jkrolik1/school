/********************************************************************************
** Form generated from reading UI file 'choseforupdate.ui'
**
** Created by: Qt User Interface Compiler version 5.15.2
**
** WARNING! All changes made in this file will be lost when recompiling UI file!
********************************************************************************/

#ifndef UI_CHOSEFORUPDATE_H
#define UI_CHOSEFORUPDATE_H

#include <QtCore/QVariant>
#include <QtWidgets/QApplication>
#include <QtWidgets/QDialog>
#include <QtWidgets/QFrame>
#include <QtWidgets/QGridLayout>
#include <QtWidgets/QHeaderView>
#include <QtWidgets/QLabel>
#include <QtWidgets/QSpacerItem>
#include <QtWidgets/QTableView>

QT_BEGIN_NAMESPACE

class Ui_choseForUpdate
{
public:
    QGridLayout *gridLayout;
    QLabel *label_2;
    QFrame *line;
    QSpacerItem *horizontalSpacer;
    QTableView *tableView;

    void setupUi(QDialog *choseForUpdate)
    {
        if (choseForUpdate->objectName().isEmpty())
            choseForUpdate->setObjectName(QString::fromUtf8("choseForUpdate"));
        choseForUpdate->resize(652, 571);
        choseForUpdate->setStyleSheet(QString::fromUtf8("background-color: rgb(64,64,64);"));
        gridLayout = new QGridLayout(choseForUpdate);
        gridLayout->setObjectName(QString::fromUtf8("gridLayout"));
        label_2 = new QLabel(choseForUpdate);
        label_2->setObjectName(QString::fromUtf8("label_2"));
        label_2->setStyleSheet(QString::fromUtf8("font-size: 17px;\n"
"color: rgb(220,220,220);\n"
"letter-spacing: 1px;"));

        gridLayout->addWidget(label_2, 0, 0, 1, 1);

        line = new QFrame(choseForUpdate);
        line->setObjectName(QString::fromUtf8("line"));
        line->setFrameShape(QFrame::HLine);
        line->setFrameShadow(QFrame::Sunken);

        gridLayout->addWidget(line, 1, 0, 1, 1);

        horizontalSpacer = new QSpacerItem(631, 20, QSizePolicy::Expanding, QSizePolicy::Minimum);

        gridLayout->addItem(horizontalSpacer, 2, 0, 1, 1);

        tableView = new QTableView(choseForUpdate);
        tableView->setObjectName(QString::fromUtf8("tableView"));
        tableView->setStyleSheet(QString::fromUtf8("background-color: 	rgb(192,192,192);\n"
""));

        gridLayout->addWidget(tableView, 3, 0, 1, 1);


        retranslateUi(choseForUpdate);

        QMetaObject::connectSlotsByName(choseForUpdate);
    } // setupUi

    void retranslateUi(QDialog *choseForUpdate)
    {
        choseForUpdate->setWindowTitle(QCoreApplication::translate("choseForUpdate", "Dialog", nullptr));
        label_2->setText(QCoreApplication::translate("choseForUpdate", "Dwukrotnie kliknij na rekordzie aby go zmieni\304\207", nullptr));
    } // retranslateUi

};

namespace Ui {
    class choseForUpdate: public Ui_choseForUpdate {};
} // namespace Ui

QT_END_NAMESPACE

#endif // UI_CHOSEFORUPDATE_H
