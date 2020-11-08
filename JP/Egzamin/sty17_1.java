package Egzamin;
import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.PrintWriter;
public class sty17_1 {

    static boolean SprawdźPlik(String nazwa_pierwsza, String nazwa_druga){
        String s;
        long licznik_jedynek=0;
        long licznik_zer=0;
        long nie_równe=0;
        boolean równość;
        try{
            BufferedReader br = new BufferedReader(new FileReader(nazwa_pierwsza));
            PrintWriter pw = new PrintWriter(new FileWriter(nazwa_druga,true),true);
            do{
                s = br.readLine();
                for(int i=0; i<s.length(); i++){
                    if(s.charAt(i)=='1') licznik_jedynek++;
                    if(s.charAt(i)=='0') licznik_zer++;
                }
                if(licznik_jedynek==licznik_zer) pw.println(s);
                if(licznik_jedynek!=licznik_zer) nie_równe++;
            }while(s!=null);
            if(nie_równe==0) {
                return true;
            }
            else {
                return false;
            }
        }
        catch(IOException e){
            e.printStackTrace();
        }
        return true;
    }
    public static void main(String[] args) {
        
    }
    
}
