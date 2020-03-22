//6 liczb calk od 1 do 49 i spr czy jedna z liczb nie jest 13
//jezeli bd jedna 13 to napis wygrales
package paź18;

import java.util.Random;

public class Dziewiaty {

    public static void main(String[] args) {

        Random r = new Random();

        int a=1, b=49;
        int x=0;
        double srednia;
        boolean wygrales=false;

        for (int i = 1; i <= 6; i++) {
            x = r.nextInt(b - a + 1) + a;
            System.out.print(x + " ");
            if (x == 13) {
                wygrales=true;
            }
        }
        if(wygrales){
            System.out.println("wygrales");
        }


    }

}
