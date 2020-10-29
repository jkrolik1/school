package paź18;

import java.util.Random;

public class Osmy {

    public static void main(String[] args) {

        Random r = new Random();

        int a=12, b=27;
        int x=0;
        double suma=0;
        double srednia;

        for (int i = 1; i <= 10; i++) {
            x = r.nextInt(b - a + 1) + a;
            System.out.print(x + " ");
            suma = suma+x;
        }
           srednia = suma/10;
           System.out.println("");System.out.println("");
           System.out.println("Średnia to: "+srednia);
           System.out.println("");
    }

}
