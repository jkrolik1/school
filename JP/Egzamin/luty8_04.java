/*
jeżeli po kropce nie ma kropki, dodaj ją.
 */
package Egzamin;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
public class luty8_04 {
    public static void main(String[] args) {
        String x;
        String wynik;
        int index,len;
        try{
            BufferedReader plik = new BufferedReader(new FileReader("a_moje1.txt"));
            PrintWriter plik2 = new PrintWriter(new FileWriter("a_moje2.txt",true),true);
            do{
                x = plik.readLine();
                if(x!=null){
                    len = x.length();
                    for(int i=0; i<len; i++){
                        if(len>(i+1)){
                            if(x.contains(".")){
                                if(x.charAt(i)=='.'){
                                    if(x.charAt(i+1)!=' '){
                                        StringBuffer sb = new StringBuffer(x);
                                        sb.replace(i,i+1,". ");
                                        wynik = sb.toString();
                                        plik2.println(wynik);
                                    }    
                                }
                            }
                            else{
                                plik2.println(x);
                            }
                        }
                        
                    }
                }
            }while(x!=null);
            plik.close();
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
    
}
