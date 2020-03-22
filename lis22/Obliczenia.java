package lis22;

public class Obliczenia {

    double moje_pi=3.48;                            //pole typu double
    
/*    Obliczenia(){
        System.out.println("Hello");
    }
*/    
        int sumka(int a, int b) {
            int suma = 0;
            for (int i = a; i <= b; i++) {
                suma = suma + i;
            }
            return suma;
        }

        int silnia_i(int n) {                        //iteracja
            int s = 1;
            for (int i = 1; i <= n; i++) {
                s = s * i;
            }
            return s;
        }

        int silnia_r(int n) {                       // rekurencyjnie (wewnatrz ta sama funkcja)
            if (n == 0) {
                return 1;
            } else {
                return silnia_r(n - 1) * n;         //tak jakby pętla. Gdy rozne od 0 wraca znowu do silnia_r 
            }
        }

        void wypiszx(String x) {
            System.out.println(x);
        }

        void wypiszy(String y) {
            System.out.println(y);
        }

        void wypiszz(String z) {
            System.out.println(z);
        }

}
