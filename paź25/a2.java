package paź25;

import java.util.Random;

public class a2 {
public static void main(String[] args) {
        Random r = new Random();
        int x=1;
        int y=49;
        boolean m=false;
        boolean n=true;
        boolean b=true;
        int l=0;
            while(!m)
                {
                n=true;
                b=true;    
                    for(int i=0; i<=5; i++)
                    {
                        int q = r.nextInt(y-x+1)+x;
                        System.out.print(q+" ");
                        if(q==16) n=false;
                        if(q==24) b=false;
                    }
                l++;
                System.out.println();
                if(!n && !b) m=true;
                }
        System.out.print("Za "+l+" razem");
    }
    
}
