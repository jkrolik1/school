package Egzamin;
import java.io.RandomAccessFile;
public class proba {
    public static void main(String[] args) {
        String s;
        try{
            RandomAccessFile f = new RandomAccessFile("dane.dat","rw");
            do{
                s = f.readUTF();
                System.out.print(s);
            }while(f.getFilePointer()<f.length());
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    
}
