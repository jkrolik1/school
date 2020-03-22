/*
suma elementow na przekatnych
 */
package lis8;
import java.util.Random;

public class Tablice_program2 {

    public static void main(String[] args) {
        
        Random r = new Random();
        int tab[][] = new int[10][10];
        final int a=1,b=2;
        
        for(int w =0; w<10; w++){
            for (int k = 0; k < 10; k++) {
                tab[w][k] = r.nextInt(b - a + 1) + a;
            }
        }
        int suma_g = 0;
        int suma_p = 0; 
        for (int w = 0; w < 10; w++) {
            for (int k = 0; k < 10; k++) {
                System.out.print(tab[w][k]+" ");
                if(w==k) suma_g=suma_g+tab[w][k];
                if(w+k==9) suma_p=suma_p+tab[w][k];  
            }
            System.out.println("");       
        }
           
        System.out.println(suma_g+" ");
        System.out.println(suma_p+" ");
        
    }
    
}
