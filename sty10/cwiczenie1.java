/*
    Proszę napisać funkcję, ktorej parametrem jest nazwa pliku tekstowego.
    Funkcja powinna zwracac liczbe pzecinkow po ktorych nie zrobiono spacji.
 */
package sty10;
import java.io.FileReader;
import java.io.IOException;
public class cwiczenie1 {
    static int przecinek(String nazwa){
        int liczba_przecinków=0,kod_znaku,licznik_pętli=0,zapis_licznika=0;
        boolean flaga=false;
        char znak;
        try{
            FileReader fr = new FileReader(nazwa);
            do{
                kod_znaku = fr.read();
                znak = (char)kod_znaku;
                if(znak==','){
                    flaga=true;
                    zapis_licznika=licznik_pętli;
                }
                if(flaga&&(licznik_pętli==(zapis_licznika+1))){
                    if(znak!=' ') liczba_przecinków++;
                }
                licznik_pętli++;
            }while(kod_znaku!=-1);
            fr.close();
        }
        catch(IOException e){
            e.printStackTrace();
        }
        return liczba_przecinków;
    }
    public static void main(String[] args) {
        int s=przecinek("kk.txt");
        System.out.print(s);
    }
    
}
