/*
slajd 9, łańcuchy, wykłady
 */
package Egzamin;
import java.util.Scanner;
public class statystyka_znaków {
    public static void main(String[] args) {
        String s="";
        int[] tab = new int[255];
        Scanner user = new Scanner(System.in);
        System.out.print("Podaj łańcuch znaków: ");
            s = user.nextLine();
            for(int i=0; i<s.length(); i++){
                tab[s.charAt(i)]++;
            }
            for(int i=0; i<tab.length;i++){
                if(tab[i]>0){
                    System.out.println((char)i+" ---> "+tab[i]);
                }
            }
        
        
        
    }
    
}
