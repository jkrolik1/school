/*
    Napisz program wyznaczający moment obrotowy
    przenoszony przez sprzęgło dla mocy N i prędkości
    obrotowej ns podanej przez użytkownika (wzór: 9550*N/ns)
 */
package Szwarc;

import java.util.Scanner;

public class Lab_3_zadanie_4 {

    public static void main(String[] args) {
        Scanner user = new Scanner(System.in);
        Double moment;
        System.out.print("Podaj moc sprzęgła: ");
        Double n = user.nextDouble();
        System.out.print("Podaj prędkość obrotową: ");
        Double v = user.nextDouble();
        moment = 9550*(n/v);
        System.out.print("Obliczbony moment obrotowy to "+moment+"\n");
    }
    
}
