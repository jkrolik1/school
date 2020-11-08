// funkcja ktora zwraca litere ktora najczesciej wystepuje w slowie nadanej jako parametr tej funkcji 
package gru20;

import java.util.Arrays;
import java.util.Collections;

public class zadanie2 {

    static char znak(String s) {
        int[] tab = new int[256];                           // kody wszy znakow sa od o do 255
        int maks=0;
        int ind=0;
        for (int i = 0; i < s.length(); i++) {
            tab[(int)s.charAt(i)]++;
        }
        for(int i=0;i<tab.length;i++){
            if(tab[i]>maks){
                maks = tab[i];
                ind = i;
            }
        }
        return (char)ind;
    }
    
    public static void main(String[] args) {
        System.out.println(znak("ala"));
    }
    
}
