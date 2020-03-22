package Egzamin;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;
import java.io.FileWriter;
import java.io.IOException;
public class program1_e {
public static void main(String[] args) {
        String s;
        long s_long;
        try{
            BufferedReader plik = new BufferedReader(new FileReader("g_moje1.txt"));
            PrintWriter plik2 = new PrintWriter(new FileWriter("g_moje2.txt",true),true);
            s = plik.readLine();
            s_long = Long.parseLong(s);
            for(long i=s_long; i>=1; i--){
                plik2.println(i);
            }
            plik.close();
            plik2.close();
        }
        catch(IOException t){
            t.printStackTrace();
        }
    }
    
}
