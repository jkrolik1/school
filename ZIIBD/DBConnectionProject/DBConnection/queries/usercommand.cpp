#include "usercommand.h"
#include "ui_usercommand.h"
#include "dialog.h"
#include <QPushButton>
#include <QLineEdit>
#include <QSqlQuery>
#include <QMessageBox>
#include <QTableView>
#include <QHeaderView>
#include <QDebug>


QLineEdit * writeLine = nullptr;

UserCommand::UserCommand(QWidget *parent) :
    QDialog(parent),
    ui(new Ui::UserCommand)
{
    ui->setupUi(this);

    setWindowFlags(Qt::WindowMinimizeButtonHint |
                   Qt::WindowMaximizeButtonHint |
                   Qt::WindowCloseButtonHint);
}

QString UserCommand::getPushButtonStyle()
{
    return this->cs3;
}

QString UserCommand::getLabelStyle()
{
    return this->cs1;
}

QString UserCommand::getLineEditStyle()
{
    return this->cs2;
}

QString UserCommand::getCommand()
{
    return this->command;
}

void UserCommand::setCommand(QString commandParam)
{
    this->command = commandParam;
}

void UserCommand::doQuery(QString oldQuery)
{
    formLayout = new QFormLayout;
    button = new QPushButton;
    buttonExit = new QPushButton;
    title = new QLabel;
    writeLine = new QLineEdit;

    button->setStyleSheet(this->getPushButtonStyle());
    buttonExit->setStyleSheet(this->getPushButtonStyle());
    title->setStyleSheet(this->getLabelStyle());
    writeLine->setStyleSheet(this->getLineEditStyle());

    if (!(oldQuery.isEmpty()))
        writeLine->setText(oldQuery);

    title->setText("Wpisz swoje polecenia do wykonania");
    button->setText("Wykonaj");
    buttonExit->setText("Wyjdź");

    formLayout->addWidget(title);
    formLayout->addWidget(writeLine);
    formLayout->addWidget(button);
    formLayout->addWidget(buttonExit);

    connect(button,SIGNAL(clicked()),this,SLOT(userQueryRealization()));
    connect(buttonExit,SIGNAL(clicked()),this,SLOT(userCommandClose()));

    setLayout(formLayout);
}

void UserCommand::userCommandClose()
{
    UserCommand::close();
}

void UserCommand::userQueryRealization()
{
    QSqlQuery ownQuery;
    QMessageBox msgBox(
                QMessageBox::Question,
                "Potwierdzenie wykonania polecenia",
                "Czy na pewno chcesz zrealizować swoje polecenie?",
                QMessageBox::Yes | QMessageBox::No);
    QMessageBox msgInfo(
                QMessageBox::Information,
                "Status operacji",
                "Wprowadzono polecenie do bazy",
                QMessageBox::Ok);
    QMessageBox msgCritical(
                QMessageBox::Critical,
                "Status operacji",
                "Wystąpił błąd. "
                "Nie wprowadzono polecenia lub polecenie jest błędne.\n",
                QMessageBox::Cancel);

    msgBox.setButtonText(QMessageBox::Yes, "Wykonaj");
    msgBox.setButtonText(QMessageBox::No, "Wyjdź");
    msgCritical.setButtonText(QMessageBox::Cancel, "Wyjdź");

    this->setCommand(writeLine->text());


    if (!(this->command.isEmpty()))
    {
        switch (msgBox.exec())
        {
            case QMessageBox::Yes:
                ownQuery.prepare(this->command);
                if(ownQuery.exec())
                {
                    QSqlDatabase::database().commit();
                    msgInfo.exec();
                    UserCommand::close();
                }
                else
                {
                    msgCritical.exec();
                    UserCommand *uc = new UserCommand;
                    uc->setWindowTitle("Wpisz swoje polecenie do bazy");
                    uc->doQuery(this->getCommand());
                    uc->show();
                    UserCommand::close();
                }
            break;
            case QMessageBox::No:
            default:
                UserCommand::close();
            break;
        }
    }
    else
        msgCritical.exec();


    if ((this->command.mid(0,6).toUpper() == "SELECT") && (ownQuery.exec()))
        this->implSELECT();
}

void UserCommand::implSELECT()
{
    model = new QSqlQueryModel;
    resulfOfSELECT = new QTableView;

    model->setQuery(this->command);

    resulfOfSELECT->setModel(model);
    resulfOfSELECT->setColumnWidth(0,230);
    resulfOfSELECT->horizontalHeader()->setSectionResizeMode
            (QHeaderView::Stretch);
    resulfOfSELECT->setStyleSheet
            ("QTableView {"
            "background-color: 	rgb(192,192,192);"
            "}");
    resulfOfSELECT->setWindowTitle
            (QObject::tr("Wynik polecenia"));
    resulfOfSELECT->resize(800,400);
    resulfOfSELECT->show();
}

UserCommand::~UserCommand()
{
    delete formLayout;
    delete button;
    delete title;
    delete writeLine;
    delete model;
    delete resulfOfSELECT;
    delete buttonExit;

    formLayout = NULL;
    button = NULL;
    title = NULL;
    writeLine = NULL;
    model = NULL;
    resulfOfSELECT = NULL;
    buttonExit = NULL;

    delete ui;
}
