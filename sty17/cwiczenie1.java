/*
    Prosze naisac funckje o nazwie zrób ktorej jedynym parametrem jest nazwa pliku.
    Funkcja powinna wpisywac do kolejnych wierszy pliku o podanej nazwie 
    losowe wartosci logiczen(True lub False). Funckja powinna zwrocic liczbe 
    wierszy pliku w ktorych wpisano true; 
 */
package sty17;
import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.FileReader;
import java.util.Random;
import java.io.IOException;

public class cwiczenie1 {

    public int zrób(String nazwa){
        int liczba_wierszy=0;
        String s;
        boolean wartość_logiczna;
        BufferedReader br;
        Random r;
        r = new Random();
        try{
            PrintWriter pw = new PrintWriter(new FileWriter(nazwa,true),true);
            for(int i=0; i<10; i++){
                pw.println(wartość_logiczna = r.nextBoolean());
                //if(wartość_logiczna) liczba_wierszy++;
            }
            br = new BufferedReader(new FileReader(nazwa));
            do{
                s = br.readLine();
                if(s.trim().equals("true")) liczba_wierszy++;
            }while(s!=null);
            pw.close();
            br.close();
        }
        catch(IOException e){
            e.printStackTrace();
        }
        return liczba_wierszy;
    }
    public static void main(String[] args) {
        
    }
}
