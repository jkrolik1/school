/*
Program który wypisuje na ekran 6 przypadkowych małych liter alfabetu
*/
package lis8;

import java.util.Random;

public class Znaki2_program {

    public static void main(String[] args) {
        Random r = new Random();
        final int a = (int)'a'; //przeksztalcenie kodu litery a 
        final int b = (int)'z'; //przeksztalcenie kodu litery z 
        for(int i=0;i<=5;i++){
            System.out.println(((char)(r.nextInt(b-a+1)+a))); 
            //rzutowanie spowrotem  na char, bo by wysietlalo kody
        }
        //a=7; final = stala,nie mozna zmienic potem
    }

}
