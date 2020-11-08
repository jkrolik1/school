package paź25;

import java.util.Random;

public class a1 {


    public static void main(String[] args) {
        Random r = new Random();
        
        double a = 1.5;
        double b = 2*Math.PI;
        double x1;
        double x2;
        int l=0;
        
        
        do {
            x1 = (b-a)*r.nextDouble()+a;
            x2 = (b-a)*r.nextDouble()+a;
            
            double x3 = x1 - x2;
            
            System.out.println(x1+" - "+x2+" = "+x3 );
            
            l++;
            
            } while((x1-x2)>1);
        
        System.out.println(l);
    }
    
}
