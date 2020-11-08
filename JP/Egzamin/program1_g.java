package Egzamin;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;
import java.io.FileWriter;
import java.io.IOException;
public class program1_g {
    public static void main(String[] args) {
        String s;
        String y;
        String odwr="";
        String[] tab;
        try{
            BufferedReader plik = new BufferedReader(new FileReader("g_moje3.txt"));
            PrintWriter plik2 = new PrintWriter(new FileWriter("g_moje4.txt",true),true);
            do{
                s = plik.readLine();
                tab = s.split(" ");
                if(tab.length==2){
                    y = tab[0]+""+tab[1];
                    for(int p=0; p<y.length(); p++){
                        odwr = y.charAt(p)+odwr;
                    }
                    plik2.println(odwr);
                    odwr="";
                }
            }while(s!=null);
            plik.close();
        }
        catch(IOException t){
            t.printStackTrace();
        }
    }
    
}
