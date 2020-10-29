package lis8;

import java.util.Random;

public class Tablice1 {


    public static void main(String[] args) {
        
        Random r = new Random();
        int tab[] = new int[10];
        final int a=1,b=49;
        
        for(int w =0; w<10; w++){
            tab[w] = r.nextInt(b-a+1)+a;
        }
        for(int w =0; w<10; w++){
            System.out.println(tab[w]+" ");
        }
        
    }
    
}
