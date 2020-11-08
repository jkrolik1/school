/*
    Napisz program pobierający od użytkownika n liczb
    całkowitych, gdzie n jest pobierane od użytkownika w
    pierwszym kroku. Wypisz największą i najmniejszą z
    wprowadzonych wartości.
 */
package Szwarc;
import java.util.Scanner;
public class Lab_4_zadanie_5 {
    public static void main(String[] args) {
        int n, liczby, max=-2147483648, min=2147483647;     // max zakresy inta
        Scanner user = new Scanner(System.in);
        System.out.print("Podaj liczbę n: ");
        if(user.hasNextInt()) {
            n = user.nextInt();
            for(int i=0; i<n; i++){
                System.out.print("Podaj "+(i+1)+" liczbę: ");
                liczby = user.nextInt();
                if(liczby>max) max = liczby;
                if(liczby<min) min = liczby;
            }
            System.out.print("Liczba max to: "+max+"\n");
            System.out.print("Liczba min to: "+min+"\n");
        }
        else System.out.print("Niepoprawne dane");
    }
    
}
