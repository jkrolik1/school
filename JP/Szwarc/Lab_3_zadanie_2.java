/*
1) Zainicjuj zmienną typu byte wartością 128.
2) Zainicjuj zmienną typu byte wartością 127, po czym
    dokonaj postinkrementacji. Wypisz wynik.
3) Zainicjuj zmienną o nazwie liczba typu double wartością
    1, po czym wypisz wynik dzielenia jej przez zero.
4) Zmiennej z zadania 3 przypisz wartość 0, po czym wypisz
    wynik dzielenia jej przez zero.
5) Zainicjuj zmienną o nazwie liczba2 typu int wartością 1, po
    czym wypisz wynik dzielenia jej przez zero
    
 */
package Szwarc;

public class Lab_3_zadanie_2 {

    public static void main(String[] args) {
        //byte pierwsza = 128;      // 1
        
        byte drugi = 127;           // 2
        drugi = drugi++;
        System.out.println(drugi);
        
        double liczba = 1;          // 3
        System.out.println(liczba/0);
        
        liczba = 0;                 // 4
        System.out.println(liczba/0);
        
        int liczba2 = 1;            // 5
        System.out.println(liczba2/0);
    }
    
}
