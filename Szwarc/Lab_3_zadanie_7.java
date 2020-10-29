/*
    Napisz program pobierający od użytkownika trzy liczby
    całkowite i wyświetlający informację która z liczb jest
    największa - „Liczba x jest największa”, gdzie x jest jej lp.
 */
package Szwarc;
import java.util.Scanner;
public class Lab_3_zadanie_7 {
    public static void main(String[] args) {
        Scanner user = new Scanner(System.in);
        System.out.print("Podaj 3 liczby: ");
            int liczba1 = user.nextInt();
            int liczba2 = user.nextInt();
            int liczba3 = user.nextInt();
        int max = liczba1;
        if(liczba2>max) max = liczba2;
        if(liczba3>max) max = liczba3;
        System.out.printf("%s%d%s","Największa liczba to: ",max,"\n");
    }
    
}
