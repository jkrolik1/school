/********************************************************************************
** Form generated from reading UI file 'usercommand.ui'
**
** Created by: Qt User Interface Compiler version 5.15.2
**
** WARNING! All changes made in this file will be lost when recompiling UI file!
********************************************************************************/

#ifndef UI_USERCOMMAND_H
#define UI_USERCOMMAND_H

#include <QtCore/QVariant>
#include <QtWidgets/QApplication>
#include <QtWidgets/QDialog>

QT_BEGIN_NAMESPACE

class Ui_UserCommand
{
public:

    void setupUi(QDialog *UserCommand)
    {
        if (UserCommand->objectName().isEmpty())
            UserCommand->setObjectName(QString::fromUtf8("UserCommand"));
        UserCommand->resize(400, 16);
        UserCommand->setStyleSheet(QString::fromUtf8("background-color: rgb(64,64,64);"));

        retranslateUi(UserCommand);

        QMetaObject::connectSlotsByName(UserCommand);
    } // setupUi

    void retranslateUi(QDialog *UserCommand)
    {
        UserCommand->setWindowTitle(QCoreApplication::translate("UserCommand", "Dialog", nullptr));
    } // retranslateUi

};

namespace Ui {
    class UserCommand: public Ui_UserCommand {};
} // namespace Ui

QT_END_NAMESPACE

#endif // UI_USERCOMMAND_H
