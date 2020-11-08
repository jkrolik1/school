package Egzamin;
import java.io.IOException;
import java.io.FileReader;
import java.io.FileWriter;
public class kopiowanie_pliku {
public static void main(String[] args) {
        int kod_znaku;
        char znak;
        String s="";
        try{
            FileReader fr = new FileReader("dane.txt");
            FileWriter fw = new FileWriter("kk.txt",false);
            do{
                kod_znaku = fr.read();
                znak = (char)kod_znaku;
                fw.write(znak);
            }while(kod_znaku!=-1);
            fr.close();
            fw.close();
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
}
