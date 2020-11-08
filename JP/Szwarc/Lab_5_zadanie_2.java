/*
    Napisz program pobierający od użytkownika dwie liczby
    całkowite, które reprezentują zakres wylosowanych liczb.
    Na ich podstawie wygeneruj pięć liczb i wypisz je na
    ekran.
 */
package Szwarc;
import java.util.Scanner;
import java.util.Random;
public class Lab_5_zadanie_2 {
public static void main(String[] args) {
        Scanner user = new Scanner(System.in);
        Random r = new Random();
        int max,min,liczby;
        
        System.out.print("Podaj zakres górny: ");
        while(!user.hasNextInt()){
            System.out.print("Nieprawidłoe dane\n\n");
            user.nextLine();
            System.out.print("Podaj zakres górny: ");
        }
        max = Integer.valueOf(user.nextLine());
        
        System.out.print("Podaj zakres dolny: ");
        while(!user.hasNextInt()){
            System.out.print("Nieprawidłoe dane\n\n");
            user.nextLine();
            System.out.print("Podaj zakres dolny: ");
        }
        min = Integer.valueOf(user.nextLine());
        
        for(int i=1; i<=5; i++){
            liczby = r.nextInt(max-min+1)+min;
            System.out.print(liczby+" ");
        }
        System.out.print("\n");
    }
    
}
