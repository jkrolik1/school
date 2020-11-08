/*
    Napisz program obliczający p
    n dla p i n wprowadzonego
    przez użytkownika. Wynik powinien zostać wypisany.
 */
package Szwarc;
import java.util.Scanner;
public class Lab_4_zadanie_6 {
public static void main(String[] args) {
        Scanner user = new Scanner(System.in);
        int p,n,wynik=1;
        System.out.print("Podaj p: ");
        if(user.hasNextInt()){
            System.out.print("Podaj n: ");
            p = user.nextInt();
            n = user.nextInt();
            for(int i=1; i<=n; i++){
                wynik=wynik*p;
            }
            System.out.print("Wynik: "+wynik+"\n");
        }
        else System.out.print("Niepoprawne dane");
    }
    
}
