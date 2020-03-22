package Szwarc;

import java.util.Scanner;

public class Lab_2_zadanie_2 {
    
    public static void main(String[] args) {
        //Scanner i = new Scanner(System.in);
        //double liczbaDouble = i.nextDouble();
        
        // 1)Zadeklaruj zmienną typu int i pobierz jej wartość od użytkownika, 
        // po czym wyświetl wiadomość ”Wpisałeś liczbę ”i wypisz pobraną wartość.
        
        Scanner calk = new Scanner(System.in);
        int liczbaCalk = calk.nextInt();
        System.out.printf("%s%d","Wpsiałeś liczbę ",liczbaCalk);
       
    }
    
}
