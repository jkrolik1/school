#include "connection.h"

Connection::Connection()
{

}

bool Connection::create_connection()
{
    bool test = false;
    QSqlDatabase db = QSqlDatabase::addDatabase("QODBC");
    db.setDatabaseName("test-bd");
    db.setUserName("Jakub");
    db.setPassword("RedBulls17");

    if(db.open())
        test = true;

    return test;
}
