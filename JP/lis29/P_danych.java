/*

 */
import java.io.RandomAccessFile;

public class P_danych {

    static void zapis(String s){
    
        

        try {

            RandomAccessFile plik = new RandomAccessFile("osoby.dat", "rw"); //(nazwa_pliku.typ_pliku,operacje na pliku = rw to read & write)
            plik.seek(plik.length()); //seek przestawia wskaźnik na () numer w nawiasie, length pobiera ostatnie miejsce wskaźnika wyrazu
            plik.writeUTF(s);
            plik.close();

        } catch (Exception e) {
            e.printStackTrace(); //komunikat o błędzie
        }
    }
    
    static void odczyt() {

        try {

            RandomAccessFile plik = new RandomAccessFile("osoby.dat", "rw"); //(nazwa_pliku.typ_pliku,operacje na pliku = rw to read & write)
            String s;
            
            do{
            s = plik.readUTF();
            System.out.println(s);
            }while(plik.getFilePointer()<plik.length());
            
            plik.close();
        } catch (Exception e) {
            e.printStackTrace(); //komunikat o błędzie
        }
    }
    
    
    
    
    
    
    public static void main(String[] args) {
        zapis("It was me, Dio!");
        odczyt();
    }

}
