/*
    Napisz program wypisujący liczby podzielne przez 3 z
    wykorzystaniem pętli for, while oraz do while (zakres od 1
    do 100).
 */
package Szwarc;

public class Lab_4_zadanie_2 {

    public static void main(String[] args) {
        for(int i=1; i<=100; i++){
            if(i%3==0) System.out.println(i);
        }
    }
    
}
