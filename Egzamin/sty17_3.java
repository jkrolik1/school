package Egzamin;
import java.io.RandomAccessFile;
import java.io.IOException;
public class sty17_3 {
    static int ObliczZamówienie(String nazwa_pliku, String nazwa_towaru_zamówionego){
        int numer_zamówienia;
        String nazwa_towaru;
        double cena;
        int liczba_sztuk;
        int liczba_sztuk_towaru_rządanego=0;
        long x=0;
        try{
            RandomAccessFile ra = new RandomAccessFile(nazwa_pliku,"rw");
            do{
                numer_zamówienia = ra.readInt();
                nazwa_towaru = ra.readUTF();
                x = ra.getFilePointer();
                cena = ra.readDouble();
                liczba_sztuk = ra.readInt();
                if((cena>50)&&(liczba_sztuk>=25)){
                    cena=cena-cena*0.1;
                    ra.seek(x);
                    ra.writeDouble(cena);
                    liczba_sztuk = ra.readInt();
                }
                if(nazwa_towaru.equals(nazwa_towaru_zamówionego)){
                    liczba_sztuk_towaru_rządanego = liczba_sztuk_towaru_rządanego + liczba_sztuk;
                }
            }while(ra.getFilePointer()<ra.length());
            ra.close();
        }
        catch(IOException e){
            e.printStackTrace();
        }
        return liczba_sztuk_towaru_rządanego;
    }
    public static void main(String[] args) {
       
    }
    
}
