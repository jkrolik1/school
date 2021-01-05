/********************************************************************************
** Form generated from reading UI file 'delete.ui'
**
** Created by: Qt User Interface Compiler version 5.15.2
**
** WARNING! All changes made in this file will be lost when recompiling UI file!
********************************************************************************/

#ifndef UI_DELETE_H
#define UI_DELETE_H

#include <QtCore/QVariant>
#include <QtWidgets/QApplication>
#include <QtWidgets/QDialog>

QT_BEGIN_NAMESPACE

class Ui_delete
{
public:

    void setupUi(QDialog *delete)
    {
        if (delete->objectName().isEmpty())
            delete->setObjectName(QString::fromUtf8("delete"));
        delete->resize(400, 300);
        delete->setStyleSheet(QString::fromUtf8("background-color: rgb(64,64,64);"));

        retranslateUi(delete);

        QMetaObject::connectSlotsByName(delete);
    } // setupUi

    void retranslateUi(QDialog *delete)
    {
        delete->setWindowTitle(QCoreApplication::translate("delete", "Dialog", nullptr));
    } // retranslateUi

};

namespace Ui {
    class delete: public Ui_delete {};
} // namespace Ui

QT_END_NAMESPACE

#endif // UI_DELETE_H
