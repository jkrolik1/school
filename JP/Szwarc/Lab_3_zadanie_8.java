/*
    Napisz program, który pobiera od użytkownika liczbę
    zmiennoprzecinkową i przypisuje jej wartość do zmiennej.
    Niech aplikacja sprawdza poprawność wprowadzonych
    danych.
 */
package Szwarc;
import java.util.Scanner;
public class Lab_3_zadanie_8 {
    public static void main(String[] args) {
        Scanner user = new Scanner(System.in);
        double liczba;
        if(user.hasNextDouble())
            liczba = user.nextDouble();
        else
            System.out.print("Niepoprawna wartość\n");
    }
    
}
