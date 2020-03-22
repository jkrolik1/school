package Projekt_edit;

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
            //e.printStackTrace();
            System.out.print("");
        }
        return suma;
    }
    
    public void usun(String x){
        String s,suma="",suma2="";
        String suma_stara1,suma_stara2;
        int suma_len;
        int index,len,len2;
        try{
            RandomAccessFile plik = new RandomAccessFile("zwierzeta.dat","rw"); 
            do{
                s = plik.readUTF();
                suma = suma+" "+s;
            }while(plik.getFilePointer() < plik.length());
            if(suma.contains(x)){
                index = suma.indexOf(x);
                len = x.length();
                len2 = index+len;
                suma_stara1 = (suma.substring(1,index)).trim();
                suma_stara2 = (suma.substring(len2)).trim();
                suma_stara2 = " "+suma_stara2;
                suma2 = suma_stara1 + "\n" + suma_stara2;
                suma2 = suma2.trim();
            }
            plik.setLength(0);
            plik.writeUTF(suma2);
            plik.writeUTF("\n");
            plik.close();
        }

        catch(Exception e){
            e.printStackTrace();
        } 
    }
    
    public void delete(){
        try{
            RandomAccessFile plik = new RandomAccessFile("zwierzeta.dat","rw"); 
            plik.setLength(0);
            plik.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    
    
    
    
    
}
