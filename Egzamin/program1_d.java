package Egzamin;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;
import java.io.FileWriter;
import java.io.IOException;
public class program1_d {
    public static void main(String[] args) {
        String ee, e;
        String dd, d;
        long n; 
        long s=1;
        try{
            BufferedReader plik = new BufferedReader(new FileReader("g_moje.txt"));
            ee = plik.readLine();
            e = plik.readLine();
            dd = plik.readLine();
            d = plik.readLine();
            n=Long.parseLong(e)/Long.parseLong(d);
            for(long i=1; i<=n; i++){
                s=s*i;
            }
            PrintWriter plik2 = new PrintWriter(new FileWriter("g_moje1.txt",true),true);
            plik2.println(s);
            System.out.println(n);
            System.out.println(s);
            plik.close();
            plik2.close();
        }
        catch(IOException t){
            t.printStackTrace();
        }
    }
    
}
