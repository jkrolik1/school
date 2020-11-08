/*
suma 2 kolumny
 */
package lis8;

import java.util.Random;

public class a6 {


    public static void main(String[] args) {
        Random r = new Random();
        int tab[][] = new int[10][10];
        int x;
        int a = 1;
        int b = 49;
        int suma_1 = 0;
        for(int w=0; w<10; w++){
            for(int k=0; k<10; k++){
                tab[w][k] = r.nextInt(b-a+1)+a;
            }
        }
        for(int w=0; w<10; w++){
            System.out.println();
            for(int k=0; k<10; k++){
                System.out.print(tab[w][k]+" ");
                if(k==1) suma_1=suma_1+tab[w][k];
                
            }
            
        }
        System.out.println();
        System.out.println("Suma 2 kolumny: "+suma_1);
    }
    
}
