/*
    Napisz program wypisujący liczby z zakreu od 1 do 100, z
    wyłączeniem liczb, które są podzielne przez 4 i
    jednocześnie są niepodzielne przez 16. Zastosuj instrukcję
    continue
 */
package Szwarc;
public class Lab_4_zadanie_4_NIEUMIANE {
    public static void main(String[] args) {
        for(int i=1; i<=100; i++){
            if((i%4!=0)&&(i%16==0)) System.out.print(i+" ");
        }
    }
    
}
