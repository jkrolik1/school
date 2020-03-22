package paź25;

import java.util.Random;

public class Dziesiaty3 {


    public static void main(String[] args) {
        int x;
        Random r = new Random();
        int suma=0;
        int ile_liczb=0;
        while(suma<100) {
            x = r.nextInt(11);
            System.out.print(x+" ");
            suma = suma+x;
            ile_liczb++;
        }
        System.out.println();
        System.out.println(ile_liczb);
        
    }
    
}
