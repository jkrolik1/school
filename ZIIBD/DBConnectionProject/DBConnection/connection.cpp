#include "connection.h"

Connection::Connection()
{

}

bool Connection::create_connection()
{
    QSqlDatabase db=QSqlDatabase::addDatabase("QODBC");
    db.setHostName("155.158.112.45");
    db.setPort(1521);
    db.setDatabaseName("oltpstud");
    db.setUserName("ziibd19");
    db.setPassword("haslo1");

    bool test = false;

    if(db.open())
        test = true;

    return test;
}
