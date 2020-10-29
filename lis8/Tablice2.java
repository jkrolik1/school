package lis8;

import java.util.Random;

public class Tablice2 {

    public static void main(String[] args) {
        
        Random r = new Random();
        int tab[][] = new int[10][10];
        final int a=1,b=49;
        
        for(int w =0; w<10; w++){
            for (int k = 0; k < 10; k++) {
                tab[w][k] = r.nextInt(b - a + 1) + a;
            }
        }
        
        for (int w = 0; w < 10; w++) {
            for (int k = 0; k < 10; k++) {
                System.out.print(tab[w][k] + " ");
            }
            System.out.println("");
        }

        
    }
    
}
