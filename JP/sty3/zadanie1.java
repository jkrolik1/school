/*
prosze napisac funkcjie ktora zwraca do prog glownego znak ktory najczesciej wystepuje w pliku plik.txt
 */
package sty3;

import java.io.FileReader;
import java.io.IOException;


public class zadanie1 {
    
    static char znak(){
        char znak=' ';
        int[] tab = new int[600];
        int kod_znaku=0;
        int maks=0;
        int znak_maks=0;
        try{
            FileReader fr = new FileReader("plik.txt");
            do{
                kod_znaku = fr.read();
                if(kod_znaku>0)
                tab[kod_znaku]++;
            }while(kod_znaku!=-1);
            
            for(int i=0; i<tab.length; i++){
                if(tab[i]>maks){
                    maks = tab[i];
                    znak_maks = i;
                }
                    
            }
            System.out.println((char)znak_maks);
            fr.close();
        }
        catch(IOException e){
            e.printStackTrace();
        }
        return znak;
    }
    public static void main(String[] args) {
        znak();
    }
    
}
