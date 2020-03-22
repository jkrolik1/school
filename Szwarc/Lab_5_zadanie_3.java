/*
    Napisz prostą grę w zgadywankę - wylosuj liczbę z
    zadanego zakresu i proś użytkownika o wpisanie kolejnych
    liczb do czasu odgadnięcia wylosowanej. Jeżeli wpisana
    liczba jest mniejsza od wylosowanej wypisz “Za mała
    wartość”, jeżeli większa “Za duża wartość”. Przy
    odgadnięciu liczby wypisz “Odgadłeś liczbę!” i zakończ
    działanie programu.
 */
package Szwarc;
import java.util.Random;
import java.util.Scanner;
public class Lab_5_zadanie_3 {
public static void main(String[] args) {
        Random r = new Random();
        Scanner user = new Scanner(System.in);
        int max,min,losowa,podana=0;
        System.out.print("Podaj zakres górny: ");
        while(!user.hasNextInt()){
            System.out.print("Niprawidłowa dana\n");
            user.nextLine();
            System.out.print("Podaj zakres górny: ");
        }
        max = Integer.valueOf(user.nextLine());
        System.out.print("Podaj zakres dolny: ");
        while(!user.hasNextInt()){
            System.out.print("Niprawidłowa dana\n");
            user.nextLine();
            System.out.print("Podaj zakres dolny: ");
        }
        min = Integer.valueOf(user.nextLine());
        losowa = r.nextInt(max-min+1)+min;
        do{
            System.out.print("Odgadnij losową liczbę z zakresu od "+min+" do "+max+": ");
            if(user.hasNextInt()){
                podana = user.nextInt();
                if(losowa>podana) System.out.print("Za mała\n");
                else if(losowa<podana) System.out.print("Za duża\n");
                else if(losowa==podana) System.out.print("Wygrałeś\n");
            }
            else System.out.print("Nieprawidłowe dane");
        }while(losowa!=podana);
    }  
}
