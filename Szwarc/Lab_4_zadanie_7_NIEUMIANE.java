// Napisz program rysujący choinkę na podstawie pobranej od użytkownika wysokości.
package Szwarc;
import java.util.Scanner;
public class Lab_4_zadanie_7_NIEUMIANE {
public static void main(String[] args) {
        Scanner user = new Scanner(System.in);
        int wys;
        System.out.print("Podaj wysokosć: ");
        if(user.hasNextInt()){
            wys = user.nextInt();
            for(int w=1; w<=wys; w++){
                System.out.println(""); 
                for(int k=1; k<=25; k++){
                    System.out.print("*");    
                }  
            }
            System.out.print("\n\n");  
        }
        else System.out.print("Nieprawidłowe dane");
    }
    
}
