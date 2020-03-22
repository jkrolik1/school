/*
prosze napisac program ktory kopiuje z pliku plik.txt do nowego pliku txt o nazwie plik2.txt z pominieciem przecinkow
 */
package sty3;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class cwiczenie1 {
    static void odczyt_znaków(){
        char znak;
        int kod_znaku;
        try{
            FileReader fr = new FileReader("plik.txt");
            FileWriter fw = new FileWriter("plik2.txt");
            do{
                kod_znaku = fr.read();
                znak = (char)kod_znaku;
                if(znak!=',')
                    fw.write(znak);
                
            }while(kod_znaku!=-1);
            
            fr.close();
            fw.close();
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        pliki_tekstowe.zapis_znaków("Na stole leży jabłko, zeszyt, szklanka");
    }
    
}
