/*
    Napisz program pobierający od użytkownika dwie liczby,
    które będą zakresem losowania (włącznie z obiema
    wartościami). Następnie wylosuj wartość z zadanego
    przedziału i wypisz jej wszystkie dzielniki. Sprawdź czy
    wprowadzony przedział jest poprawny (pierwsza liczba
    jest mniejsza od drugiej) - jeżeli nie, to skoryguj błąd.
 */
package Szwarc;
import java.util.Random;
import java.util.Scanner;
public class Lab_5_zadanie_6 {
public static void main(String[] args) {
        int max,min,losowa;
        Random r = new Random();
        Scanner user = new Scanner(System.in);
        System.out.print("Podaj wartość górną: ");
        if(user.hasNextInt()){
            max = user.nextInt();
            System.out.print("Podaj wartość dolną: ");
            if(user.hasNextInt()){
                min = user.nextInt();
                losowa = r.nextInt(max-min+1)+min;
                System.out.print(losowa+"\n");
                System.out.print("Dzielniki: ");
                for(int i=1; i<=losowa; i++){
                    if(losowa%i==0) System.out.print(i+" ");
                }
            }
            else System.out.print("Podaj liczbę całkowitą\n");
        }
        else System.out.print("Podaj liczbę całkowitą\n");
        

    }
    
}
