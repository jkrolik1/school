/*
    Pobierz od użytkownika liczbę całkowitą i wypisz jej
    resztę z dzielenia przez 2 oraz 1. Wpisz liczby od 1 do 5.
 */
package Szwarc;
import java.util.Scanner;
public class Lab_3_zadanie_5 {
    public static void main(String[] args) {
        Scanner user = new Scanner(System.in);
        System.out.printf("%s", "Podaj liczbę: ");
        int liczba = user.nextInt();
        double reszta1 = liczba%2;
        double reszta2 = liczba%1;
        System.out.printf("%s%f%s","Reszta z dzielenia przez 2: ",reszta1,"\n");
        System.out.printf("%s%f%s","Reszta z dzielenia przez 1: ",reszta2,"\n");
    }
    
}
