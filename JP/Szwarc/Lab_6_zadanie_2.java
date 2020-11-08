/*
    Napisz program pobierający od użytkownika kolejne linijki
    tekstu i tworzący z nich jeden ciąg do momentu
    wystąpienia w zdaniu słowa “stop” (usuń z otrzymanej
    wartości wszystkie znaki od słowa “stop” włącznie).
    Wykorzystaj StringBuildera.
 */
package Szwarc;
import java.util.Scanner;
public class Lab_6_zadanie_2 {
public static void main(String[] args) {
        Scanner user = new Scanner(System.in);
        System.out.print("Podaj ciąg znaków: ");
        String linia = user.nextLine();
        int index,len;
        String nowy;
        len = linia.length();
        for(int i=0; i<len; i++){
            if(linia.contains("stop")){
                index = linia.indexOf("stop");
                StringBuffer s = new StringBuffer(linia);
                s.delete(index,len);
                linia = s.toString();
            }
        }
        System.out.println(linia);
    }
    
}
