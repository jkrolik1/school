/*
    Napisz program pobierający od użytkownika trzy liczby
    całkowite i wyświetlający informację czy pierwsza liczba
    jest większa od drugiej oraz trzeciej.
 */
package Szwarc;
import java.util.Scanner;
public class Lab_3_zadanie_6 {
    public static void main(String[] args) {
        Scanner user = new Scanner(System.in);
        System.out.print("Podaj 3 liczby całkowite: ");
        int liczba1, liczba2, liczba3;
            liczba1 = user.nextInt();
            liczba2 = user.nextInt();
            liczba3 = user.nextInt();
                if((liczba1>liczba2)&&(liczba1>liczba3)) 
                    System.out.print("Pierwsza liczba jest większa od pozostałych \n");
                else if((liczba1<liczba2)&&(liczba1<liczba3)) 
                    System.out.print("Pierwsza liczba jest mniejsza od pozostałych \n");
                else 
                    System.out.print("Inny wniosek \n");
    }
    
}
