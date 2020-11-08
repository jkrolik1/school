package lis22;


public class Funkcje1 {

    static int sumka(){
        int suma=0;
        for(int i=1; i<=10;  i++) suma=suma+i;
        return suma;
    }

    public static void main(String[] args) {
        int x = sumka();
        System.out.print(x);
    }
    
}
