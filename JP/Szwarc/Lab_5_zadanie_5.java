/*
    Napisz program pobierający od użytkownika kolejne liczby
    całkowite do momentu wprowadzenia liczby 0. Niech
    program wyznaczy i wypisze średnią arytmetyczną
    wprowadzonych wartości oraz minimalną i maksymalną z
    wpisanych liczb.
 */
package Szwarc;
import java.util.Scanner;
public class Lab_5_zadanie_5 {
public static void main(String[] args) {
        Scanner user = new Scanner(System.in);
        double liczby,suma=0,srednia=0,i=0,max=-(Math.pow(2,63)),min=Math.pow(2,63);
        System.out.print("Podaj liczbę: ");
        if(user.hasNextDouble()){
            do{
                if(i!=0)System.out.print("Podaj liczbę: ");
                liczby = user.nextDouble();
                if(liczby>max) max = liczby;
                if((liczby<min)&&(liczby!=0)) min = liczby;
                suma = suma+liczby;
                i++;
            }while(liczby!=0);
            srednia = suma/(i-1);
            System.out.print("Średnia: "+srednia+"\n");
            System.out.print("Minimalna: "+min+"\n");
            System.out.print("Maksymalna: "+max+"\n");
        }
        else System.out.print("Nieprawidłowa wartość");
    }
    
}
