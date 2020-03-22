/*
Użytkownik gra w totolotka. Proszę napisać program
obliczający ile zakładów na chybil trafil powinien
zglosic aby trafic dwie liczby 16 i 24 w jednym
zakladzie 6 liczowym. Program powinien 
przeprowadzic tylko jeden eksperyment.
 */
package lis15.powtorki;

import java.util.Random;

public class pierwszy {

    public static void main(String[] args) {
        Random r = new Random();
        int a=1;
        int b=49;
        int x;
        
        boolean all=true;
        boolean one=false;
        boolean two=false;
        
        int licz=0;
        
        
            while(all){
                one=false;
                two=false;
                for(int i=0;i<6;i++){
                    x = r.nextInt(b-a+1)+a;
                    System.out.print(x+" ");
                    if(x==16) one=true;
                    if(x==24) two=true;
                    
                }
                System.out.println();
                if(one && two) all=false;
                licz++;
            }

        System.out.println();
        System.out.println(licz);
    }
    
}
