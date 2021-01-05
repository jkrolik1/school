#ifndef CONNECTION_H
#define CONNECTION_H

#include <QSqlDatabase>
#include <QSqlError>
#include <QSqlQuery>

class Connection
{
public:
    Connection();
    ~Connection();
    bool create_connection();
private:
    QSqlDatabase db;
};

#endif // CONNECTION_H
