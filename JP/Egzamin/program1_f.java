package Egzamin;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;
import java.io.FileWriter;
import java.io.IOException;
public class program1_f {
    public static void main(String[] args) {
        String s;
        String liczby;
        String liczby_ost;
        try{
            BufferedReader plik = new BufferedReader(new FileReader("g_moje2.txt"));
            PrintWriter plik2 = new PrintWriter(new FileWriter("g_moje3.txt",true),true);
            do{
                s = plik.readLine();
                for(int i=0; i<s.length(); i++){
                    if(s.charAt(0)<s.charAt(1)){
                        liczby = s.charAt(1)+""+s.charAt(0);
                        plik2.println(s + " " + liczby);
                    }
                }
            }while(s!=null);
            plik.close();
            plik2.close();
        }
        catch(IOException t){
            t.printStackTrace();
        }
    }
    
}
