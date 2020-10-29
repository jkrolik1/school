package lis22;

public class Funkcje3 {

    static int sumka(int a, int b) {
        int suma = 0;
        for (int i = a; i <= b; i++) {
            suma = suma + i;
        }
        return suma;
    }
    
    static void wypisz(String x){
        System.out.print(x);
    }

    public static void main(String[] args) {
        int x; 
        x = sumka(90,100);
        wypisz(x+"");
    }

}
