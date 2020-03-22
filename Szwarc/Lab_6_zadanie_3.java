/*
    Napisz program pobierający od użytkownika linijkę tekstu
    i zastępujący co drugi znak znakiem nowej linii (’\n’).
    Wypisz otrzymaną wartość. Wykorzystaj StringBuildera.
 */
package Szwarc;
import java.util.Scanner;
public class Lab_6_zadanie_3 {
public static void main(String[] args) {
        Scanner user = new Scanner(System.in);
        System.out.print("Podaj linie tekstu: ");
        String linia = user.nextLine();
        StringBuffer sb = new StringBuffer(linia);
        for(int i=0; i<linia.length(); i++){
            if(i%2!=0) sb.replace(i, i+1, "\n");
        }
        linia = sb.toString();
        System.out.print(linia+"\n");
    }
    
}
