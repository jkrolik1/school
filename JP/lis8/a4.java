/*
Proszę wypełnić tablice kwadratowa 10 wierszy i 10 koolumn l.calk od 1 do 49 
obl i zapisz sume wszy ele
 */
package lis8;

import java.util.Random;

public class a4 {


    public static void main(String[] args) {
        Random r = new Random();
        int tab[][] = new int[10][10];
        int x;
        int a = 1;
        int b = 49;
        int suma = 0;
        for(int w=0; w<10; w++){
            for(int k=0; k<10; k++){
                tab[w][k] = r.nextInt(b-a+1)+a;
            }
        }
        for(int w=0; w<10; w++){
            System.out.println();
            for(int k=0; k<10; k++){
                System.out.print(tab[w][k]+" ");
                suma = suma+tab[w][k];
            }
            
        }
        System.out.println();
        System.out.println("Suma: "+suma);
    }
    
}
