/*
Tabliczka mnozenia z tablic
 */
package lis8;

public class b1 {


    public static void main(String[] args) {
        int tab[][] = new int[11][11];
        
        for(int w=0; w<11; w++){
            for(int k=0; k<11; k++){
                int o=w*k;
                if(k==0) tab[w][k] = w;
                if(w==0) tab[w][k] = k;
                if((k!=w)||(k==w)){
                    tab[w][k] = o;
                } 
            }
        }
        for(int w=0; w<11; w++){
            for(int k=0; k<11; k++){
                if(tab[w][k]==100) System.out.print(tab[w][k]+" ");
                else if((tab[w][k]>=1)&&(tab[w][k]<=9)) System.out.print(tab[w][k]+"   ");
                else if((tab[w][k]>=10)&&(tab[w][k]<=99)) System.out.print(tab[w][k]+"  "); 
            }
            System.out.println("");
        }
    }
        
    
}
