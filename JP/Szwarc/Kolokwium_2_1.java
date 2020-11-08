/*
    Napisz metodę tworzącą dwuwymiarową tablicę o losowej
    wielkości (z zakresu [10,15]) zawierającą różną liczbę
    wierszy i kolumn (podpowiedź: po wylosowaniu dwóch
    liczb sprawdź czy są one identyczne - jeżeli tak, to zmień
    drugą z nich). Następnie należy wypełnić ją losowymi
    wartościami zmiennoprzecinkowymi z zakresu [0,1] (z
    wyjątkiem elementów znajdujących się na pozycji [i,i] -
    mają one mieć wartość 1). Niech metoda zwraca średnią
    wartość znajdującą się w tablicy
 */
package Szwarc;
import java.util.Random;
public class Kolokwium_2_1 {

    static double metoda(){
        Random r = new Random();
        int a = 10,b = 15;
        double a2 = 0,b2 = 1;
        double suma=0,srednia=0;
        int losowa1,losowa2;
        int l_kol=0,l_wier=0,liczba;
        losowa1 = r.nextInt(b-a+1)+a;
        losowa2 = r.nextInt(b-a+1)+a;
        do{
            losowa2 = r.nextInt(b-a+1)+a;
        }while(losowa1==losowa2);
        double tab[][] = new double[losowa1][losowa2];
        for(int w=0; w<losowa1; w++){
            for(int k=0; k<losowa2; k++){
                tab[w][k] = (b2-a2)*r.nextDouble()+a2;
                suma = suma+tab[w][k];
                l_kol++;
            }
            l_wier++;
        }
        liczba = l_wier+l_kol;
        srednia = suma/(liczba);
        return srednia;
    }
    public static void main(String[] args) {
        double x = metoda();
        System.out.print(x);
    }
    
}
