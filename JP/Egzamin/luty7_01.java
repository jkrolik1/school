package Egzamin;
import java.util.Random;
import java.io.RandomAccessFile;
import java.io.IOException;
public class luty7_01 {
    public static void main(String[] args) {
        int[][] tablica1 = null;
        Random r = new Random();
        int a = 1;
        int b = 255;
        try{
            RandomAccessFile plik1 = new RandomAccessFile("a_moje1.dat","rw");
            tablica1 = new int[10][10];
            for(int w=0; w<10; w++){
                for(int k=0; k<10; k++){
                    tablica1[w][k] = r.nextInt(b-a+1)+a;
                }
            }
            for(int w=0; w<10; w++){
                for(int k=0; k<10; k++){
                    plik1.seek(plik1.length());
                    plik1.writeInt(tablica1[w][k]);
                    plik1.writeUTF(" ");
                }
                plik1.writeUTF("\n");
            }
            
            plik1.close();
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
    
}
