package lis8;

import java.util.Random;

public class a1 {
    
    public static void main(String[] args) {
        Random r = new Random();
        
        double x;
        double a = 100.0;
        double b = 200.0;
        double max = 100;
        double min = 200;
        
        for(int i=1; i<=100; i++){
            x = (b-a)*r.nextDouble()+a;
            System.out.print(x+"("+i+")"+" ");
            if(x>max) max=x;
            if(x<min) min=x;
        }
        System.out.println();
        System.out.println("Max: "+max);
        System.out.println("Min: "+min);
        
        
    }
    
}
