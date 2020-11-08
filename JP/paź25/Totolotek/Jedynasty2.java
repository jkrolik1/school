/*
Użytkownik gra w totolotka. Proszę napisać program
obliczający ile zakładów na chybil trafil powinien
zglosic aby trafic trzy liczby 16, 24 i 36 w jednym
zakladzie 6 liczowym. Program powinien 
przeprowadzic tylko jeden eksperyment.
*/
package paź25.Totolotek;

import java.util.Random;

public class Jedynasty2 {

    public static void main(String[] args) {
        Random r = new Random();
        
        int a=1;
        int b=49;
        int l=0;
        
        boolean los=false;
        boolean los1=true;
        boolean los2=true;
        boolean los3=true;
        
        while(!los){
            los1 = true;
            los2 = true;    
            los3 = true;    
                for (int k=0;k<=5;k++){   
                    int x = r.nextInt(b-a+1)+a;
                    System.out.print(x+" ");
                    if(x==16) los1=false;
                    if (x==24) los2 = false;
                    if (x==36) los3 = false;
                }
                System.out.println("");
                l++;
                if(!los1 && !los2 && !los3) los = true;
        }
        System.out.println("\nIlosc losowan: " +l+ "\n");
    }
}
