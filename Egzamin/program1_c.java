package Egzamin;
import java.io.IOException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.io.FileWriter;
public class program1_c {
    public static void main(String[] args) {
        int kod_znaku;
        int licznik = 0;
        int licznik_a = 0;
        int znak_pierwszy=0;
        char znak;
        int indeksy_suma=0;
        int indeksy_il;
        int indeks_3=1;
        int liczba1;
        int liczba2;
        int liczba3;
        String s="";
        try{
            FileReader plik = new FileReader("c_moje.txt");
            do{
                kod_znaku = plik.read();
                znak = (char)kod_znaku;
                if(licznik==0){
                    znak_pierwszy = kod_znaku;
                }
                if(znak=='a'){
                    licznik_a++;
                }
                s = s + znak;
                licznik++;
            }while(kod_znaku!=-1);
            if(licznik_a>=3){
                indeksy_suma = s.indexOf('a') + s.lastIndexOf('a');
                for(int i=0; i<s.length(); i++){
                    if(s.charAt(i)=='a'){
                        liczba1 = i+1;
                        for(int n=liczba1; n<s.length(); n++){
                            if(s.charAt(n)=='a'){
                                liczba2 = n+1;
                                for(int p=liczba2; p<s.length(); p++){
                                    if(s.charAt(p)=='a'){
                                        indeks_3=p;
                                        p=s.length();
                                        i=s.length();
                                        n=s.length();
                                    }
                                }
                            }
                        }
                    }
                }
            }
            else{
                indeksy_suma = s.indexOf('a') + s.lastIndexOf('a');
            }
            indeksy_il = indeks_3*indeksy_suma;
            System.out.println("s:"+s);
            System.out.println("");
            System.out.println("Indeks 1: "+s.indexOf('a'));
            System.out.println("Indeks ost: "+s.lastIndexOf('a'));
            System.out.println("Indeks 3: "+indeks_3);
            System.out.println("Koniec: "+indeksy_il);
            PrintWriter pw = new PrintWriter(new FileWriter("g_moje.txt",true),true);
            pw.println("e");
            pw.println(indeksy_il);
            pw.println("d");
            pw.println(znak_pierwszy);
            System.out.println("");
            plik.close();
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
    
}
