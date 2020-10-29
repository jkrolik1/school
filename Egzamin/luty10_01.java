// losuje wyraz zaczynający się od a
package Egzamin;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Random;
public class luty10_01 {
public static void main(String[] args) {
    String s, wyraz;
    String[] tab;
    String[] tablica;
    tablica = new String[255];
    int licznik=0,b=0,a=0,losowa;
        try{
            Random r = new Random();
            BufferedReader plik = new BufferedReader(new FileReader("a_moje1.txt"));
            do{
                s = plik.readLine();
                if(s!=null){
                    tab = s.split(" ");
                    for(int w=0; w<tab.length; w++){
                        wyraz = tab[w];
                        if(wyraz.contains("a")){
                            if((wyraz.charAt(0)=='a')&&(wyraz.length()>1)){
                                tablica[licznik] = wyraz;
                                licznik++;
                            }
                        }
                    }
                }
            }while(s!=null);
            
            b = licznik-1;
            losowa = r.nextInt(b-a+1)+a;
            System.out.print("Wszystkie słowa na \"a\": ");
            for(int i=0; i<tablica.length; i++){
                if(tablica[i]!=null) System.out.print(tablica[i]+" ");
            }
            System.out.println("\nLosowe słowo: "+tablica[losowa]);
            plik.close();
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
    
}
