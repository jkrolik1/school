/*
    2) w tym pliku cene zwiększyć o 10% (RandomAccessFile)
 */
package Egzamin;
import java.io.RandomAccessFile;
import java.io.IOException;
public class sty10_2 {
    public static void main(String[] args) {
        String s,suma="";
        try{
           RandomAccessFile plik = new RandomAccessFile("tekstowy.dat","rw"); 
           do{
               s = plik.readUTF();
               System.out.println(s);
           }while(plik.getFilePointer()<plik.length());
           plik.close();
        }
        catch(IOException e){
            System.out.print("\n");
        }
    }
    
}
