package lis22;

public class Funkcje2 {

    static int sumka(int b) {
        int suma = 0;
        for (int i = 1; i <= b; i++) {
            suma = suma + i;
        }
        return suma;
    }

    public static void main(String[] args) {
        int x = sumka(100);
        System.out.print(x);
    }

}
