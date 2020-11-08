/*
Generuje 100 liczb przypadkowych rzeczywistych z zakresu 100 - 200 
i wykrywa ktora z tych liczb byla max a ktora minimalna
 */
package lis15.powtorki;

import java.util.Random;

public class Trzeci {

    public static void main(String[] args) {
        Random r = new Random();
        Double a = 100.0;
        Double b = 200.0;
        Double x;
        Double max=0.0;
        Double min=200.0;
        for(int i=1; i<=100; i++){
            x = (b-a)*r.nextDouble()+a;
            System.out.print(x+" ");
            if(x>max) max=x;
            if(x<min) min=x;
        }
        System.out.println();
        System.out.print(max+" ");
        System.out.print(min+" ");
    }
    
}
