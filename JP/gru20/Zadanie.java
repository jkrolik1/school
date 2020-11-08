package gru20;

import java.io.RandomAccessFile;
import java.io.IOException;

public class Zadanie {

    void moja(String nazwa_pliku, String p_nazwa_towaru) {
        String nazwa_towaru;
        double cena;
        int liczba_sztuk;
        int liczba=0;
        long x;
        try {
            RandomAccessFile f = new RandomAccessFile(nazwa_pliku,"rw");
            while (f.getFilePointer() < f.length()){
                nazwa_towaru = f.readUTF();
                x = f.getFilePointer();
                cena = f.readDouble();
                liczba_sztuk = f.readInt();
                if(liczba_sztuk>=100){
                    cena=0.9*cena;
                    f.seek(x);
                    f.writeDouble(cena);
                    liczba_sztuk = f.readInt();
                }
                if(nazwa_towaru.equals(p_nazwa_towaru)){
                    liczba = liczba+liczba_sztuk;
                }
            }
            f.close();
        } 
        catch (IOException e) {
            System.out.println("Błąd IO");
        }
    }
}
