#include "dialog.h"

#include <QApplication>

int main(int argc, char *argv[])
{
    QApplication a(argc, argv);
    Dialog w;
    w.setWindowTitle("Połączenie z bazą danych ZIIBD");
    w.show();
    return a.exec();
}
