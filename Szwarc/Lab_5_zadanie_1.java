/*
    Zainicjuj zmienną typu double wartością 9,997 i przypisz
    jej wartość do zmiennej typu int, dokonując rzutowania.
    Wypisz otrzymay wynik.

    Zmienną z zadania 1 wypisz na ekran, dokonując
    rzutowania na typ int w momencie przekazania wartości
    do metody println.

    Dokonaj rzutowania liczby 100 na typ char, przekazując
    wartość do metody println.
 */
package Szwarc;

public class Lab_5_zadanie_1 {

    public static void main(String[] args) {
        double zmienna = 9.997;
        int zmienna1;
        zmienna1 = (int)zmienna;
        System.out.print(zmienna1+"\n");
        
        System.out.print((int)zmienna+"\n");
        
        System.out.print((char)100+"\n");
    }
    
}
