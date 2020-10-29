package paź25;

import java.util.Random;

public class a {


    public static void main(String[] args) {
    
        Random r = new Random();
        
        int y=1;
        int z=49;
        
        boolean a=false;
        boolean u=true;
        boolean q=true;
        
        int l=0;
        
        while(!a)
        {
            u=true;
            q=true;
            for(int i=1; i<=6; i++)
            {
                int x = r.nextInt(z-y+1)+y;
                System.out.print(x+" ");
                if(x==16) u=false;
                if(x==24) q=false;
                
            }
            System.out.print(" ");
            System.out.println();
            l++;
            if(!u & !q) a=true;
        }
        System.out.print("Za "+l+" razem");
        
    }
    
}
