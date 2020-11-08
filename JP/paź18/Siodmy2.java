package paź18;


import java.util.Random;

public class Siodmy2 {

    public static void main(String[] args) {

        Random r = new Random();

        int x;            
        boolean c;          
        double d;   
        int a = 1, b = 49;

        for(int i=1;i<=6;i++) {
            x = r.nextInt(b-a+1)+a;
            System.out.print(x+" ");
        }


    }

}
