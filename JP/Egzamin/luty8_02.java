/*
    Napisać metodę przyjmującą jako parametr ścieżki dwóch
    plików tekstowych oraz znak, który ma zostać wyszukany.
    Ma ona zwracać pozycję pierwszego wystąpienia -
    przekazanego znaku - w pliku znajdującym się pod
    adresem wskazanym przez pierwszy parametr oraz
    zapisywać do pliku tekstowego - mającego się znaleźć pod
    adresem przekazanym w drugim parametrze - zdania z
    pierwszego pliku, zawierające zastąpiony przekazany znak
    wartością #.
 */
package Egzamin;
import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.PrintWriter;
public class luty8_02 {
    static int metoda(String ścieżka1, String ścieżka2, char znak){
        int kod_znaku;
        int index=0;
        int index2;
        char znak2;
        String s = null;
        String l = null;
        String t = null;
        try{
            FileReader plik = new FileReader(ścieżka1);
            PrintWriter plik2 = new PrintWriter(new FileWriter(ścieżka2,true),true);
            BufferedReader plik3 = new BufferedReader(new FileReader(ścieżka1));
            do{
                kod_znaku = plik.read();
                znak2 = (char)kod_znaku;
                do{
                    s = s + znak2;
                }while(znak2!=znak);
                index = s.indexOf(znak2);
            }while(kod_znaku!=-1);
            do{
                l=plik3.readLine();
                if(l!=null){
                    for(int i=0; i<l.length(); i++){
                        if(l.charAt(i)==znak){
                            StringBuffer sb = new StringBuffer(l);
                            sb.replace(i,i+1,"#");
                            t = sb.toString();
                            plik2.println(t);
                        }
                    }
                }
            }while(l!=null);
            plik.close();
            plik2.close();
            plik3.close();
        }
        catch(IOException e){
            e.printStackTrace();
        }
        return index;
    }
    public static void main(String[] args) {
        metoda("a_moje1.txt","a_moje2.txt",'e');
    }
    
}
