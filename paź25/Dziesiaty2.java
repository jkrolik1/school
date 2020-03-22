package paź25;

import java.util.Random;

public class Dziesiaty2 {


    public static void main(String[] args) {
        int x;
        boolean b=true;
        Random r = new Random();
        int suma=0;
        int ile_liczb=0;
        while(b) {
            x = r.nextInt(11);
            System.out.print(x+" ");
            suma = suma+x;
            ile_liczb++;
            if(suma>100) b=false;
        }
        System.out.println();
        System.out.println(ile_liczb);
        
    }
    
}
