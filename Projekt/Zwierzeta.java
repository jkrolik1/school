package Projekt;

import java.io.RandomAccessFile;

public class Zwierzeta {
    String rodzaj;
    String imie;
    
    Zwierzeta(String rodzaj, String imie){
        this.rodzaj = rodzaj;
        this.imie = imie;
    }
    
    void zapisz(){
        try{
            RandomAccessFile plik = new RandomAccessFile("zwierzeta.dat","rw"); 
            plik.seek(plik.length());
            plik.writeUTF(this.rodzaj);
            plik.writeUTF(this.imie);
            plik.writeUTF("\n");
            plik.close();

        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    

    public String odczyt(){
        
        String suma="";
        String s="";
        
        
        try{
            RandomAccessFile plik = new RandomAccessFile("zwierzeta.dat","rw"); 
            
                do{
                    s = plik.readUTF();
                    suma = suma+" "+s;
                }while(plik.getFilePointer() < plik.length());
        }

        catch(Exception e){
            e.printStackTrace();
        }
        return suma;
    }
    
    
    
    
    
}
