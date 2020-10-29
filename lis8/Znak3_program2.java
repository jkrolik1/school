/*
prosze napisac program ktory tak dlugo 
generuje duze litery alfabetu dopoki 
nie wystapi litera "V"
wszystkie literki powinny byc wyswietlane
 */
package lis8;

import java.util.Random;

public class Znak3_program2 {


    public static void main(String[] args) {
        Random r = new Random();
        final int a = (int)'A';
        final int b = (int)'Z';
        int p;
        do{
            p = r.nextInt(b - a + 1) + a;
            System.out.print((char)p+" ");
        }while(p!=(int)'V');
    }
    
}
