package Szwarc;
import java.io.RandomAccessFile;
public class Lab_8_zadanie_1 {

    static void odczyt(){
        String s,ciag="";
        int index_of_k, ciag_len;
        try{
            RandomAccessFile plik = new RandomAccessFile("tekstowy.txt","rw");
            do{
                s = plik.readLine();
                ciag = ciag+s;
            }while(plik.getFilePointer()<plik.length());
            ciag_len = ciag.length();
            for(int i=0;i<ciag_len;i++){
                if(ciag.charAt(i)=='k'){
                    index_of_k = ciag.indexOf('k');
                    StringBuffer sb = new StringBuffer(ciag);
                    sb.delete(index_of_k,ciag_len);
                    ciag = sb.toString();
                }
            }
            System.out.print(ciag);
            plik.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
    }
    public static void main(String[] args) {
        odczyt();
    }
    
}
