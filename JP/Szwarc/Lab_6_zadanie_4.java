/*
    Napisz program tworzący dwudziestoelementową tablicę
    wypełnioną losowymi wartościami z zakresu 0-1 (typu
    zmiennoprzecinkowego). Aplikacja powinna wypisać
    średnią arytmetyczną, najmniejszą oraz największą z liczb
    znajdujących się w tablicy.
 */
package Szwarc;
import java.util.Arrays;
import java.util.Random;
public class Lab_6_zadanie_4 {
    public static void main(String[] args) {
        Random r = new Random();
        double b=1;
        double a=0;
        double min=Math.pow(2, 63);
        double max=-(Math.pow(2, 63));
        double suma=0;
        double srednia;
        double tab[] = new double[20];
        for(int i=0; i<tab.length; i++){
            tab[i] = (b-a)*r.nextDouble()+a;
            suma = suma+tab[i];
            if(tab[i]>max) max = tab[i];
            if(tab[i]<min) min = tab[i];
        }
        srednia = suma/tab.length;
        System.out.println("Średnia: "+srednia);
        System.out.println("Minimalna: "+min);
        System.out.println("Maksymalna: "+max);
        Arrays.sort(tab);
        System.out.println("");
        System.out.println("");
        for(int i=0; i<tab.length; i++){
            System.out.println(tab[i]+"\n");
        }
    }
    
}
