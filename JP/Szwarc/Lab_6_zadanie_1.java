/*
    Napisz program pobierający od użytkownika linijkę tekstu
    (metoda nextLine klasy Scanner) i przypisz ją do
    zmiennej typu String.
    Zamień wszystkie znaki na małe w zmiennej utworzonej w
    pierwszym punkcie i wypisz jej nową wartość.
 */
package Szwarc;
import java.util.Scanner;
public class Lab_6_zadanie_1 {
public static void main(String[] args) {
        Scanner user = new Scanner(System.in);
        String linia = user.nextLine();
        linia = linia.toLowerCase();
        System.out.println(linia);
    }
    
}
