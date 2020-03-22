/*
    Napisać metodę przyjmującą jako parametr ścieżkę pliku
    danych, w kórym są zapisane dane w postaci: imię
    (String) nazwisko (String) pensja (int) wiek (int). W
    wyniku działania metody mają zostać nadpisane wartości
    pensji dla wieku większego niż 40.
 */
package Egzamin;
import java.io.RandomAccessFile;
import java.io.IOException;
public class luty8_01 {
    public void metoda(String ścieżka){
        String imie,nazwisko;
        int pensja,wiek;
        long x;
        try{
            RandomAccessFile plik = new RandomAccessFile(ścieżka,"rw");
            do{
                imie = plik.readUTF();
                nazwisko = plik.readUTF();
                x = plik.getFilePointer();
                pensja = plik.readInt();
                wiek = plik.readInt();
                if(wiek>40){
                    plik.seek(x);
                    plik.write(pensja);
                    wiek = plik.readInt();
                }
            }while(plik.getFilePointer()<plik.length());
            plik.close();
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args) {}
}
