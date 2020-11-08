package paź18;

import java.util.Random;

public class Siodmy {

    public static void main(String[] args) {
        
        Random r = new Random();
        
        int a=1, b=49;
        double aa = 1.0, bb = 49.0;
        
        int x = r.nextInt(b-a+1)+a;             //!!!!!!!!!!!!!!!!!!!!!!!!
        boolean c = r.nextBoolean();            //!!!!!!!!!!!!!!!!!!!!!!!!
        double d = (bb-aa)*r.nextDouble()+aa;   //!!!!!!!!!!!!!!!!!!!!!!!!
        
        System.out.println(x);
        System.out.println(c);
        System.out.println(d);
        
    }
    
}
