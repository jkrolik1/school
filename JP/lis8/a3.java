/*
prosze napisac program ktory tak dlugo 
generuje duze litery alfabetu dopoki 
nie wystapi litera "V"
wszystkie literki powinny byc wyswietlane
 */
package lis8;

import java.util.Random;

public class a3 {


    public static void main(String[] args) {
        Random r = new Random();
        int a = (int)'A';
        int b = (int)'Z';
        int x = 0;
        int i = 0;
        while(x!=(char)'V'){
            x = r.nextInt(b-a+1)+a;
            System.out.print((char)x+" ");
            i++;
        }
        System.out.println();
        System.out.println("Za "+i+" proba");
    }
    
}
