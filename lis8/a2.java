
package lis8;

import java.util.Random;

public class a2 {


    public static void main(String[] args) {
        Random r = new Random();
        
        int x;
        final int a = 'a';
        final int b = 'z';
        
        for(int i=1; i<=6; i++){
            x = r.nextInt(b-a+1)+a;
            System.out.print((char)x+" ");
        }
        
    }
    
}
