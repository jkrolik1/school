/*
Generuje 100 liczb przypadkowych rzeczywistych z zakresu 100 - 200 
i wykrywa ktora z tych liczb byla max a ktora minimalna
 */
package lis8;

import java.util.Random;

public class Max_i_min_z_liczb_losowych {


    public static void main(String[] args) {
        Random r = new Random();
        double p;
        double a=100.0;
        double b=200.0;
        double max=0;
        double min=200;
        int imax =0;
        int imin =0;
        for(int i = 1; i<=100; i++){
            p = (b-a)*r.nextDouble()+a;
            System.out.print(p+"("+i+")"+" ");
                if(p>max){max = p; imax = i;}
                if(p<min){min = p; imin = i;}
        }
        System.out.println("");
        System.out.println(max+"("+imax+") ");
        System.out.println(min+"("+imin+") ");
    }
    
}
