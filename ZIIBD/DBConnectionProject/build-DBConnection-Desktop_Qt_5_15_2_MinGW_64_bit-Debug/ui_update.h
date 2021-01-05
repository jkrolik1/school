/********************************************************************************
** Form generated from reading UI file 'update.ui'
**
** Created by: Qt User Interface Compiler version 5.15.2
**
** WARNING! All changes made in this file will be lost when recompiling UI file!
********************************************************************************/

#ifndef UI_UPDATE_H
#define UI_UPDATE_H

#include <QtCore/QVariant>
#include <QtWidgets/QApplication>
#include <QtWidgets/QDialog>

QT_BEGIN_NAMESPACE

class Ui_update
{
public:

    void setupUi(QDialog *update)
    {
        if (update->objectName().isEmpty())
            update->setObjectName(QString::fromUtf8("update"));
        update->resize(400, 300);
        update->setStyleSheet(QString::fromUtf8("background-color: rgb(64,64,64);"));

        retranslateUi(update);

        QMetaObject::connectSlotsByName(update);
    } // setupUi

    void retranslateUi(QDialog *update)
    {
        update->setWindowTitle(QCoreApplication::translate("update", "Dialog", nullptr));
    } // retranslateUi

};

namespace Ui {
    class update: public Ui_update {};
} // namespace Ui

QT_END_NAMESPACE

#endif // UI_UPDATE_H
