package lis22;

public class Funkcje5 {

    static int sumka(int a, int b) {
        int suma = 0;
        for (int i = a; i <= b; i++) {
            suma = suma + i;
        }
        return suma;
    }

    static int silnia_i(int n) {                   //iteracja
        int s = 1;
        for (int i = 1; i <= n; i++) {
            s = s * i;
        }
        return s;
    }
    
    static int silnia_r(int n){                 // rekurencyjnie (wewnatrz ta sama funkcja)
        if(n == 0)
            return 1;
        else
            return silnia_r(n-1)*n;             //tak jakby pętla. Gdy rozne od 0 wraca znowu do silnia_r 
    }

    
    static void wypiszx(String x) {
        System.out.println(x);
    }
    static void wypiszy(String y) {
        System.out.println(y);
    }
    static void wypiszz(String z) {
        System.out.println(z);
    }

    public static void main(String[] args) {
        int x, y, z;
        x = sumka(90, 100);
        y = silnia_i(5);
        z = silnia_r(5);
        wypiszx(x + "");
        wypiszy(y + "");
        wypiszz(z + "");
    }

}
