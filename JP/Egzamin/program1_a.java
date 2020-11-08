package Egzamin;
import java.io.IOException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Random;
public class program1_a {
    public static void main(String[] args) {
        int losowa;
        int a=1;
        int b=255;
        String s="";
        int licznik=1;
        int licznik2=1;
        try{
            PrintWriter plik = new PrintWriter(new FileWriter("a_moje1.txt",true),true);
            Random r = new Random();
            do{
                do{
                    losowa = r.nextInt(b-a+1)+a;
                    if(licznik!=10) s = s + losowa + " ";
                    else s = s + losowa;
                    licznik++;
                }while(licznik<=10);
                plik.println(s);
                s="";
                licznik=1;
                licznik2++;
            }while(licznik2<=10);
            plik.close();
        }
        catch(IOException t){
            t.printStackTrace();
        }
    }
    
}
