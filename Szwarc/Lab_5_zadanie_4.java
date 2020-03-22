/*
    Napisz program obliczający częstość drgań swobodnych
    nietłumionych ω0 na podstawie całkowitej sprężystości k
    oraz bezwzględności m podanej przez użytkownika (wzór=pierw(k/m))
 */
package Szwarc;
import java.util.Scanner;
public class Lab_5_zadanie_4 {
    public static void main(String[] args) {
        Scanner user = new Scanner(System.in);
        int k,m,w,t;
        System.out.print("Podaj wartość sprężystości: ");
        while(!user.hasNextInt()){
            System.out.print("Podaj prawidłową wartość");
            user.nextLine();
        }
        k = Integer.valueOf(user.nextLine());
        
        System.out.print("Podaj wartość bezwzględności: ");
        while(!user.hasNextInt()){
            System.out.print("Podaj prawidłową wartość");
            user.nextLine();
        }
        m = Integer.valueOf(user.nextLine());
        w=(int)k/m;
        w=(int)Math.sqrt(w);
        t=(int)(2*Math.PI);
        t=t/w;
        System.out.print("Częstość drgań swobodnych nietłumionych : "+w+"\n");
        System.out.print("Okres drgań swobodnych nietłumionych nietłumionych : "+t+"\n");
    }
    
}
