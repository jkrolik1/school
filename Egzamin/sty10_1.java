/*
    1) txt spr ile razy wyst literka a
 */
package Egzamin;
import java.io.IOException;
import java.io.FileReader;
public class sty10_1 {
    public static void main(String[] args) {
        int kod_znaku, ilość=0;
        char znak;
        try{
            FileReader fr = new FileReader("plik.txt");
            do{
                kod_znaku=fr.read();
                znak=(char)kod_znaku;
                if(znak=='a') ilość++;
            }while(kod_znaku!=-1);
            System.out.println(ilość);
            fr.close();
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
    
}
