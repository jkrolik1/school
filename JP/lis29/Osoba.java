package lis29;
import java.io.RandomAccessFile;

/*
Proszę napisać klasę umożliwiającą gromadzenie
informacji o osobach.
 */
public class Osoba {
    int lp;
    String imie;
    String nazwisko;
 
      
      
    Osoba(int lp, String imie, String nazwisko){
         this.lp = lp;
        this.imie = imie;
        this.nazwisko = nazwisko;
       
        }
    
    void wypisz(){
        System.out.print(imie+" "+nazwisko+" ");
    }
    
    
    
  void zapisz(){
        
      try{
        RandomAccessFile plik = new RandomAccessFile("osoby.dat","rw");
          plik.seek(plik.length());
          System.out.println(this.lp);
          plik.writeInt(this.lp);
          plik.writeUTF(this.imie);
          plik.writeUTF(this.nazwisko);
          plik.close();
      }catch(Exception e){
         e.printStackTrace();
      }
    }
    
       void odczyt( ){
   
        
      try{
          RandomAccessFile plik = new RandomAccessFile("osoby.dat","rw");
       
          if(plik.getFilePointer() < plik.length()) {
            this.lp = plik.readInt();
            this.imie = plik.readUTF();
           this.nazwisko = plik.readUTF();
          }
             
         
       
      }catch(Exception e){
         e.printStackTrace();
      }
    }
    
       
           
       void odczyt2( int wsk){
   
        
      try{
          RandomAccessFile plik = new RandomAccessFile("osoby.dat","rw");
          boolean b1=false,b2=false;
          do{
            b1= plik.getFilePointer() < plik.length();
            if(b1){
             this.lp = plik.readInt();
             this.imie = plik.readUTF();
             this.nazwisko = plik.readUTF();
            }
            b2 = (lp == wsk);
           }
           while(b1 && !b2  );
       
             
         
       
      }catch(Exception e){
         e.printStackTrace();
      }
    }
    
    
    
    
}
