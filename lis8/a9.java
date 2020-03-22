/* Tworzenie 5 literowych wyrazów w tablicy 10x10*/
package lis8;

import java.util.Random;

public class a9 {


    public static void main(String[] args) {
        Random r = new Random();

        int tabb[][][] = new int[10][10][5];
        int x;
        int a='a';
        int b='z';

            for(int ww=0; ww<10; ww++){
                for(int kk=0; kk<10; kk++){
                    for(int xx=0; xx<5; xx++){
                        x = r.nextInt(b-a+1)+a;
                        tabb[ww][kk][xx] = x;
                    }
                }
            }

            for(int ww=0; ww<10; ww++){
                for(int kk=0; kk<10; kk++){
                    for(int xx=0; xx<5; xx++){
                        System.out.print((char)tabb[ww][kk][xx]+"");  
                    }
                System.out.print(" ");
                }
            System.out.println();
            }
    }
}
    
    

