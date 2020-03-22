package lis22;

public class Funkcje4 {

    static int sumka(int a, int b) {
        int suma = 0;
        for (int i = a; i <= b; i++) {
            suma = suma + i;
        }
        return suma;
    }
    
    static int silnia(int n){
        int s=1;
        for(int i=1; i<=n; i++){
            s = s*i;
        }
        return s;
    }

    static void wypiszx(String x) {
        System.out.println(x);
    }
    
    static void wypiszy(String y) {
        System.out.println(y);
    }

    public static void main(String[] args) {
        int x,y;
        x = sumka(90, 100);
        y = silnia(5);
        wypiszx(x + "");
        wypiszy(y + "");
    }

}
