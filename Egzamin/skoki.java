package Egzamin;
import java.io.RandomAccessFile;
import java.io.IOException;
public class skoki {
    static void nadwaga(String plik){
        String imie,płeć;
        double waga=0,wzrost=0,bmi;
        try{
            bmi=((waga)/(wzrost*wzrost));
            RandomAccessFile f = new RandomAccessFile(plik,"rw");
            RandomAccessFile nadwaga = new RandomAccessFile("nadwaga.bin","rw");
            RandomAccessFile niedowaga = new RandomAccessFile("niedowaga.bin","rw");
            do{
                imie = f.readUTF();
                płeć = f.readUTF();
                waga = f.readDouble();
                wzrost = f.readDouble();
                if(bmi<18.5){
                    niedowaga.seek(niedowaga.length());
                    niedowaga.writeUTF(imie);
                    niedowaga.writeDouble(waga);
                    niedowaga.writeDouble(bmi);
                }
                else if(bmi>=25.0){
                    nadwaga.seek(niedowaga.length());
                    nadwaga.writeUTF(imie);
                    nadwaga.writeDouble(bmi);
                }
            }while(f.getFilePointer()<f.length());
            f.close();
            nadwaga.close();
            niedowaga.close();
            
        }
        catch(IOException e){
            e.printStackTrace();
        }
        
    }
    
    public static void main(String[] args) {
        String imie,płeć;
        double waga=0,wzrost=0,bmi;
        try{
            bmi=((waga)/(wzrost*wzrost));
            RandomAccessFile f = new RandomAccessFile("dane.dat","rw");
            RandomAccessFile nadwaga = new RandomAccessFile("nadwaga.bin","rw");
            RandomAccessFile niedowaga = new RandomAccessFile("niedowaga.bin","rw");
            do{
                imie = f.readUTF();
                płeć = f.readUTF();
                waga = f.readDouble();
                wzrost = f.readDouble();
                if(bmi<18.5){
                    niedowaga.seek(niedowaga.length());
                    niedowaga.writeUTF(imie);
                    niedowaga.writeDouble(waga);
                    niedowaga.writeDouble(bmi);
                }
                else if(bmi>=25.0){
                    nadwaga.seek(niedowaga.length());
                    nadwaga.writeUTF(imie);
                    nadwaga.writeDouble(bmi);
                }
            }while(f.getFilePointer()<f.length());
            f.close();
            nadwaga.close();
            niedowaga.close();
            
        }
        catch(IOException e){
            e.printStackTrace();
        }
        //nadwaga("dane.txt");
    }
    
    
}
