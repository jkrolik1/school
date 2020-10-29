/*
    Proszę napisać klase o nazwie Laptop, której konstruktor posiada 3 pola klasy:
        String nazwa
        String producent
        double cena
    Dodatkowo metoda o nazwie dopisz powinna umozliwiac dopisanie 
    do pliku danych o nazwie laptopy.bin wszy info dot obiektu tej klasy oraz zwrocic aktualna liczbe obiekow w pliku (juz po dopisaniu)
 */
package sty17;
import java.io.RandomAccessFile;
import java.io.IOException;
public class Laptop {
    String nazwa;
    String producent;
    double cena;
    Laptop(String nazwa, String producent, double cena){
        this.nazwa = nazwa;
        this.producent = producent;
        this.cena = cena;
    }
    int dopisz(){
        int liczba_obiektów=0;
        try{
            RandomAccessFile plik = new RandomAccessFile("laptopy.bin", "rw");
            plik.seek(plik.length());
            plik.writeUTF(this.nazwa);
            plik.writeUTF(this.producent);
            plik.writeDouble(this.cena);
            do{
                nazwa = plik.readUTF();
                producent = plik.readUTF();
                cena = plik.readDouble();
                liczba_obiektów++;
            }while(plik.getFilePointer()<plik.length());
            plik.close();
        }
        catch(IOException e){
            e.printStackTrace();
        }
        return liczba_obiektów;
    }
}
