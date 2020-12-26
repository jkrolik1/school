#include "connection.h"

Connection::Connection()
{

}

bool Connection::create_connection()
{
    db = QSqlDatabase::database();
    db = QSqlDatabase::addDatabase("QODBC");
    db.setDatabaseName("oracle");
    db.setUserName("ziibd19");
    db.setPassword("haslo1");

    bool test = false;

    if(db.open())
        test = true;

    return test;
}

Connection::~Connection()
{
    //db.close();
}
