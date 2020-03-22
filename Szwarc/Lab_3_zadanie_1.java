/*
    Napisz program pobierający od użytkownika dwie liczby
    całkowite, obliczający ich średnią arytmetyczną
    i wyświetlający wynik.
 */
package Szwarc;
import java.util.Scanner;

public class Lab_3_zadanie_1 {

    public static void main(String[] args) {
        Scanner liczba = new Scanner(System.in);
        
        System.out.print("Podaj 1 liczbę: ");
        int liczba1 = liczba.nextInt();
        
        System.out.print("Podaj 2 liczbę: ");
        int liczba2 = liczba.nextInt();
        
        int srednia = (liczba1+liczba2)/2;
        System.out.printf("%s%d%s","Średnia = ",srednia,"\n");
    }
    
}
