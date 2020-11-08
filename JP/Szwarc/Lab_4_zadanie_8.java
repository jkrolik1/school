/*
    5 Napisz program, który dla pobranej liczby całkowitej
    wyznaczy jej wszystkie dzielniki i wypisze je na ekran.
 */
package Szwarc;
import java.util.Scanner;
public class Lab_4_zadanie_8 {
public static void main(String[] args) {
        Scanner user = new Scanner(System.in);
        int liczba;
        System.out.print("Podaj liczbę: ");
        if(user.hasNextInt()){
            liczba = user.nextInt();
            System.out.print("Dzielniki: ");
            for(int i=1; i<=liczba; i++){
                if(liczba%i==0) System.out.print(i+ " ");
            }
            System.out.print("\n");
        }
        else System.out.print("Nieprawidłowe dane");
    }   
}
