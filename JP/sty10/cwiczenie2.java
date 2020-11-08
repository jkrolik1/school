/*
    Prosze napisac funkcje ktorej parametrem jest nazwa pliku tekstowego. 
    Funkcja powinna zwracac liczbe wierszy, we wskazanym pliku, ale takich w ktorych przynajmniej 2 razy wystapilo slowo java
 */
package sty10;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
public class cwiczenie2 {
static int wiersze(String path){
    String s;
    String[] tab=null;
    int index=0;
    int liczba=0;
    int liczba2=0;
    int len;
    try{
        BufferedReader br = new BufferedReader(new FileReader(path));
        do{
            s = br.readLine();
            if(s!=null){
                tab = s.split(" ");
                len = tab.length;
                for(int i=0; i<len; i++){
                    if("java".equals(tab[i])){
                        liczba = i+1;
                        for(int n=liczba; n<len; n++){
                            if(tab[n].equals("java")){
                                liczba2++;
                                len = 0;
                            }
                        }
                    }
                }
            }
        }while(s!=null);
        System.out.println(liczba2);
    }
    catch(IOException e){
        e.printStackTrace();
    }
    return liczba;
}
    public static void main(String[] args) {
        wiersze("ppp.txt");
    }
    
}
