 /*
    Napisz program pobierający od użytkownika n liczb
    całkowitych (gdzie n jest podane przez użytkownika w
    pierwszym kroku), obliczający ich średnią arytmetyczną
    i wyświetlający wynik.
 */
package Szwarc;

import java.util.Scanner;

public class Lab_4_zadanie_1 {

    public static void main(String[] args) {
        int n;
        double liczby, suma=0, srednia;
        Scanner user = new Scanner(System.in);
        
        System.out.print("Podaj liczbę liczb: ");
        
        if(user.hasNextInt()){ 
            n = user.nextInt();
            for(int i=0; i<n; i++){
                System.out.printf("%s%d%s%d%s","Podaj ",i+1,"/",n," liczbę: ");
                liczby = user.nextDouble();
                suma=suma+liczby;
            }
            srednia = suma/n;
            System.out.printf("%s%f%s", "Średnia: ",srednia,"\n");
        }
        else System.out.print("Niepoprawna wartość. Podaj liczbę całkowitą.\n");
        
        
    }
    
}
