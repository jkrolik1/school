/* Napisz program który generuje dwie liczby przypadkowe, 
rzeczywiste x1 i x2 z zakresu od 1.5 do 2*Pi tak długo 
dopóki różnica x1-x2 jest > 1 */
package paź25.generowanie;

import java.util.Random;

public class Trzynasty {

    public static void main(String[] args) {
        Random r = new Random();
        int s = 0;
        double a = 1.5;
        double b = 2 * Math.PI;
        int l = 0;
        double x1, x2;

        do {
            x1 = (b - a) * r.nextDouble() + a;
            x2 = (b - a) * r.nextDouble() + a;
            double w = x1 - x2;

            System.out.println(x1 + " - " + x2 + " = " + w + "\n");

            l++;
        } while ((x1 - x2) < 1);
        System.out.print("za: " + l + "\n");
    }

   

}
