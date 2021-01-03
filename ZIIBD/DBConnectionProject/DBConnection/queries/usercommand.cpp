#include "usercommand.h"
#include "ui_usercommand.h"
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

void UserCommand::doQuery()
{
    formLayout = new QFormLayout;
    button = new QPushButton;
    title = new QLabel;
    writeLine = new QLineEdit;

    button->setStyleSheet(this->getPushButtonStyle());
    title->setStyleSheet(this->getLabelStyle());
    writeLine->setStyleSheet(this->getLineEditStyle());

    title->setText("Wpisz swoje polecenia do wykonania");
    button->setText("Wykonaj");

    formLayout->addWidget(title);
    formLayout->addWidget(writeLine);
    formLayout->addWidget(button);

    connect(button,
            SIGNAL(clicked()),
            this,
            SLOT(userQueryRealization()));

    setLayout(formLayout);
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
                "Wystąpił błąd. Nie wprowadzono polecenia.\n",
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
    {
        msgCritical.exec();
        UserCommand::close();
    }


    if (this->command.mid(0,6).toUpper() == "SELECT")
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

    formLayout = NULL;
    button = NULL;
    title = NULL;
    writeLine = NULL;
    model = NULL;
    resulfOfSELECT = NULL;


    delete ui;
}
