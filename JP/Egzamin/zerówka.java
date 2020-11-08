package Egzamin;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;
public class zerówka {

    static void Sinus(String nazwa_pliku, double x, double n){
        double czynnik_1, czynnik_2, czynnik_3, czynnik_4, czynnik_5, sigma=0, sin_sigmy;
        int silnia = 1;
        int EPS = 0;
        for(int u=0; u<=n; u++){
            czynnik_1 = (2*n)+1;
            czynnik_2 = Math.pow(x,czynnik_1);
            for(int i=1; i<=czynnik_1; i++){
                silnia = silnia * i;
            }
            czynnik_3 = czynnik_2/silnia;
            czynnik_4 = Math.pow(-1,n);
            czynnik_5 = czynnik_4*czynnik_3;
            sigma = sigma+czynnik_5;
        }
        sin_sigmy = Math.sin(sigma);
        
        try{
            PrintWriter pw = new PrintWriter(new FileWriter(nazwa_pliku,true),true);
            do{
                pw.println(sin_sigmy);
                pw.println(EPS);
                pw.println(x);
            }while(EPS==0);
            
            
            pw.close();
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {}
    
}
