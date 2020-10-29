/*
Prosze napisac program ktory wypelnia tablice 10x10 przypadkowymi literkami alfabetu od j do n
 */
package lis15;

import java.util.Random;

public class Powtorka {

    public static void main(String[] args) {
       Random r = new Random();
       char tab[][] = new char[10][10];
       int a = (int)'j';
       int b = (int)'n';
       int x;
       for(int w=0; w<10; w++){
           for(int k=0; k<10; k++){
               x = r.nextInt(b-a+1)+a;
               tab[w][k] = (char)x;
               System.out.print(tab[w][k]+" ");
           }
           System.out.println();
       }
    }
    
}
