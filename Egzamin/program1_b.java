package Egzamin;
import java.io.IOException;
import java.io.RandomAccessFile;
public class program1_b {
    public static void main(String[] args) {
        int liczba;
        char liczba_char;
        int licznik=1;
        int licznik2=1;
        long x;
        boolean podzielność,podzielność2,podzielność3,warunek;
        podzielność = licznik%2==0;
        podzielność2 = licznik%20==0;
        podzielność3 = ((licznik%18==0)&&(licznik!=90));
        warunek = ((licznik==98)||(licznik==92)||(licznik==94)||(licznik==96)||(licznik==74)||(licznik==78)||(licznik==58)||(licznik==12)||(licznik==14)||(licznik==16)||(licznik==32)||(licznik==34)||(licznik==52)||(licznik==56));
        try{
            RandomAccessFile plik = new RandomAccessFile("a_moje1.txt","rw");
            RandomAccessFile plik2 = new RandomAccessFile("c_moje.txt","rw");
            do{
                x = plik.getFilePointer();
                if((plik.getFilePointer()<plik.length())||(licznik<=100)){
                    liczba = plik.readInt();
                    if(podzielność&&podzielność2&&podzielność3&&warunek){
                        plik.seek(x);
                        liczba_char = (char)liczba;
                        plik.writeChar(liczba_char);
                        plik2.writeChar(liczba_char+' ');
                        if(licznik2%10==0) plik2.writeUTF("\n");
                        liczba = plik.readInt();
                        licznik2++;
                    } 
                    licznik++;
                }
            }while((plik.getFilePointer()<plik.length())||(licznik<=100));
            plik.close();
            plik2.close();
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
    
}
