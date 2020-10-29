/*

 */
package lis8;

import java.util.Random;

public class a5 {


    public static void main(String[] args) {
        Random r = new Random();
        int tab[][] = new int[10][10];
        int x;
        int a = 1;
        int b = 49;
        int suma_1 = 0;
        int suma_2 = 0;
        for(int w=0; w<10; w++){
            for(int k=0; k<10; k++){
                tab[w][k] = r.nextInt(b-a+1)+a;
            }
        }
        for(int w=0; w<10; w++){
            System.out.println();
            for(int k=0; k<10; k++){
                System.out.print(tab[w][k]+" ");
                if(w==k) suma_1=suma_1+tab[w][k];
                if(w+k==9) suma_2=suma_2+tab[w][k];
                
            }
            
        }
        System.out.println();
        System.out.println("Suma: "+suma_1);
        System.out.println("Suma: "+suma_2);
    }
    
}
