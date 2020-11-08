package Egzamin;
import java.io.RandomAccessFile;
import java.io.IOException;
public class proba2 {
public int liczba_towaru(String nazwa_pliku, String nazwa_t){
    String nazwa_towaru;
    double cena;
    int liczba_sztuk;
    int liczba=0;
    long x;
    try{
        RandomAccessFile f = new RandomAccessFile(nazwa_pliku,"rw");
        do{
            nazwa_towaru = f.readUTF();
            x = f.getFilePointer();
            cena = f.readDouble();
            liczba_sztuk = f.readInt();
            if(liczba_sztuk>=100){
                cena = cena*0.9;
                f.seek(x);
                f.writeDouble(cena);
                liczba_sztuk = f.readInt();
            }
            if((nazwa_towaru).equals(nazwa_t)){
                liczba=liczba+liczba_sztuk;
            }
        }while(f.getFilePointer()<f.length());
        f.close();
    }
    catch(IOException e){
        System.out.print("Błąd IO");
    }
    return liczba;    
}    
public static void main(String[] args) {
    }
}
