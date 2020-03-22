package sty3;
//import java.io.FileWriter
//import java.io.FileReader
//import java.io.BufferedReader
//import java.io.PrintWriter
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
public class pliki_tekstowe {
    
    static void odczyt_znaków(){
        char znak;
        int kod_znaku;
        try{
            FileReader fr = new FileReader("plik.txt");
            do{
                kod_znaku = fr.read();
                znak = (char)kod_znaku;
                System.out.print(znak);
            }while(kod_znaku!=-1);
            
            fr.close();
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
    static void zapis_znaków(String s){
        try{
            FileWriter fw = new FileWriter("plik.txt",false); //false od nowa utworzony, true dopisywanie
            for(int i=0; i<s.length(); i++){
                fw.write(s.charAt(i));
            }
            fw.close();
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
    static void zapisz_wiersza(String s){
        try{
            PrintWriter pw = new PrintWriter(new FileWriter("plik.txt",true),true);
            pw.println(s);
            pw.close();
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
    static void odczyt_wierszy(){
        String s;
        
        try{
            BufferedReader br = new BufferedReader(new FileReader("plik.txt"));
            do{
                s=br.readLine();
                if(s!=null)
                    System.out.println(s);
            }while(s!=null);
            br.close();
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args) {
        //zapis_znaków("Witaj w nowym roku");
        //odczyt_znaków();
        zapisz_wiersza("Witaj nowy roku");
        zapisz_wiersza("Hello");
        odczyt_wierszy();
       
        
    }
    
}
