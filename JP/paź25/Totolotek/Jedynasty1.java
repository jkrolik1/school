/*
uzytk gra w totolotka tak dlugo jak nie trafi liczb 16 i 24; dopóki w 6 cyfrowym zakladzie nie padną dwie liczby.
prog obliczający ile zakladow bd musial zlecic aby wygral raz 2

Użytkownik gra w totolotka. Proszę napisać program
obliczający ile zakładów na chybil trafil powinien
zglosic aby trafic dwie liczby 16 i 24 w jednym
zakladzie 6 liczowym. Program powinien 
przeprowadzic tylko jeden eksperyment.

generuje patrze czy jedna 16 czy 24 jak trafil te dwie to koniec jak nie to generuje kolejne 6 liczb
 */
package paź25.Totolotek;

import java.util.Random;

public class Jedynasty1 {

    public static void main(String[] args) {
        Random r = new Random();

        int a = 1;
        int b = 49;
        int l = 0;

        boolean los = false; //dopóki obie liczby się nie pojawiły
        boolean los1 = true;
        boolean los2 = true;

        while (!los) {
            los1 = true;
            los2 = true;
            for (int k = 0; k <= 5; k++) {
                int x = r.nextInt(b - a + 1) + a;
                System.out.print(x + " ");
                if (x == 16) los1 = false;
                if (x == 24) los2 = false;
            }
            System.out.println("");
            l++;
            if (!los1 && !los2) los = true;
        }
        System.out.println("\nIlosc losowan: " + l + "\n");
    }
}
