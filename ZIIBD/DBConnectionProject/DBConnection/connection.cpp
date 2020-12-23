#include "connection.h"

Connection::Connection()
{

}

bool Connection::create_connection()
{
    QSqlDatabase db=QSqlDatabase::addDatabase("QODBC");
    db.setDatabaseName("oracle");
    db.setUserName("ziibd19");
    db.setPassword("haslo1");

    bool test = false;

    if(db.open())
        test = true;

    return test;
}
