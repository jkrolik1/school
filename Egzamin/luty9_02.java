package Egzamin;
import java.io.RandomAccessFile;
import java.io.IOException;
public class luty9_02 {
    public int funkcja(String nazwa_pliku, String nazwa_towaru_parametr){
        String[] nazwa_towaru;
        double[] cena;
        int[] liczba_sztuk; 
        int liczba_sztuk_parametr=0;
        long x, len;
        int len_2;
        try{
            RandomAccessFile plik = new RandomAccessFile(nazwa_pliku,"rw");
            len = plik.length();
            len_2 = (int)len;
            nazwa_towaru = new String[len_2];
            cena = new double[len_2];
            liczba_sztuk = new int[len_2];
            do{
                for(int w=0; w<plik.length(); w++){
                    nazwa_towaru[w] = plik.readUTF();
                    x = plik.getFilePointer();
                    cena[w] = plik.readDouble();
                    liczba_sztuk[w] = plik.readInt();
                    if(liczba_sztuk[w]>=100){
                        cena[w] = cena[w] - cena[w]*0.1;
                        plik.seek(x);
                        plik.writeDouble(cena[w]);
                        liczba_sztuk[w] = plik.readInt();
                    }
                    if(nazwa_towaru.equals(nazwa_towaru_parametr)){
                        liczba_sztuk_parametr = liczba_sztuk[w];
                    }
                }
            }while(plik.getFilePointer()<plik.length());
            plik.close();
        }
        catch(IOException e){
            e.printStackTrace();
        }
        return liczba_sztuk_parametr;
    }
    public static void main(String[] args) {}
    
}
