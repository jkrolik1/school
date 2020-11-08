package paź25;

import java.util.Random;

public class a3 {


    public static void main(String[] args) {
        Random r  = new Random();
        
        int a = 1;
        int b = 49;
        int l=0;
        
        boolean all = false;
        boolean one = true;
        boolean two = true;
        
        while(!all){
        one = true;
        two = true;
            for(int i=1; i<=6; i++){
                int x = r.nextInt(b-a+1)+a;
                System.out.print(x+" ");
                if (x==16) one = false;
                if (x==24) two = false;
            }
        System.out.println();   
        if(!one && !two) all = true;
        l++;
        }
        System.out.println("Za "+l);  
    }
    
}
