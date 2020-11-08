/*
    Napisz konwerter walut przeliczający złotówki na dolary
    oraz euro.
 */
package Szwarc;

import java.util.Scanner;

public class Lab_3_zadanie_3 {

    public static void main(String[] args) {
        Scanner podana = new Scanner(System.in);
        System.out.print("Podaj wartość w złotówkach: ");
        double zloto = podana.nextDouble();
        double dolary, euro;
        dolary = zloto*0.27;
        euro = zloto*4.31;
        System.out.printf("%s%f%s","Twoja wartość w dolarach: ",dolary,"\n");
        System.out.printf("%s%f%s","Twoja wartość w euro: ",euro,"\n");
    }
    
    
}
