import java.io.RandomAccessFile;

public class PlikiDanych {


    static void zapis( String s){
        
      try{
          RandomAccessFile plik = new RandomAccessFile("osoby.dat","rw");
          plik.seek(plik.length());
          plik.writeUTF(s);
          plik.close();
      }catch(Exception e){
         e.printStackTrace();
      }
    }
    
        static void odczyt( ){
        String s;
        
      try{
          RandomAccessFile plik = new RandomAccessFile("osoby.dat","rw");
         do{
          s = plik.readUTF();
          System.out.println(s);
         }
         while(plik.getFilePointer()<plik.length());          
         
         plik.close();
      }catch(Exception e){
         e.printStackTrace();
      }
    }
    
    
    
    public static void main(String[] args) {
       zapis("Hello");
       odczyt();
        
    }
    
}
