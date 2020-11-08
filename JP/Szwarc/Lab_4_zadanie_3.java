/*
    silnia
 */
package Szwarc;

import java.util.Scanner;

public class Lab_4_zadanie_3 {

    public static void main(String[] args) {
        Scanner user = new Scanner(System.in);
        long liczba,s=1;
        System.out.print("Podaj liczbę: ");
        if(user.hasNextLong()){
            liczba = user.nextLong();
            for(int i=1; i<=liczba; i++){
                s=s*i;
            }
            System.out.print("Silnia to: "+s+"\n");
        }
        else System.out.print("Niepoprawne dane");
            
    }
    
}
