package Egzamin;
import java.util.Scanner;
public class proba3 {
    public static void main(String[] args) {
        int[] tab = new int[256];
        int maks=0;
        int ind=0;
        Scanner user = new Scanner(System.in);
        String wpisz = user.nextLine();
        for(int i=0; i<wpisz.length(); i++){
            tab[(int)wpisz.charAt(i)]++;
        }
        for(int i=0; i<tab.length; i++){
            if(tab[i]>maks){
                maks = tab[i];
                ind = i;
                
            }
        }
        System.out.print((char)ind+" ---> "+maks);
    }
    
}
