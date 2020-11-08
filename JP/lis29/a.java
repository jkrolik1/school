package lis29;
import java.io.RandomAccessFile;
import java.util.Random;
public class a {
    static void zapis(int s){
        try{
            RandomAccessFile plik = new RandomAccessFile("a.dat","rw");
            plik.seek(plik.length());
            plik.writeInt(s);
            plik.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    static void odczyt(){
        try{
            RandomAccessFile plik = new RandomAccessFile("a.dat","rw");
            int s;
            do{
                s = plik.readInt();
                System.out.println(s);
            }while(plik.getFilePointer()<plik.length());
            plik.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
public static void main(String[] args) {
    Random r = new Random();
    int losowa;
    int b = 100;
    int a = 1;
    losowa = r.nextInt(b-a+1)+a;
        zapis(losowa);
        odczyt();
    }
}
