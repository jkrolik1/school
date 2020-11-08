/*
    Napisać metodę przyjmującą jako parametr ścieżki dwóch
    plików tekstowych oraz znak, który ma zostać wyszukany.
    Ma ona zwracać pozycję pierwszego wystąpienia -
    przekazanego znaku - w pliku znajdującym się pod
    adresem wskazanym przez pierwszy parametr oraz
    zapisywać do pliku tekstowego - mającego się znaleźć pod
    adresem przekazanym w drugim parametrze - zdania z
    pierwszego pliku, zawierające zastąpiony przekazany znak
    wartością #.
 */
package Szwarc;
import java.io.RandomAccessFile;
public class Kolokwium_2_2 {

    static int metoda(String path1,String path2,char sign){
        String s,all="";
        int len,index=0;
        try{
            RandomAccessFile plik1 = new RandomAccessFile(path1,"rw");
            do{
                s = plik1.readLine();
                all = all+s;
            }while(plik1.getFilePointer()<plik1.length());
            len = all.length();
            for(int i=0; i<len; i++){
                if(all.charAt(i)==sign){
                    index = all.indexOf(sign);
                    StringBuffer sb = new StringBuffer(all);
                    sb.replace(index,index+1,"#");
                    all = sb.toString();
                    break;
                }
            }
            all = all.trim();
            RandomAccessFile plik2 = new RandomAccessFile(path2,"rw");
            plik2.seek(plik2.length());
            plik2.writeUTF(all);
            plik1.close();
            plik2.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
      return index;  
    }
    public static void main(String[] args) {
        int x = metoda("path1.txt","path2.txt",'d');
        System.out.print(x);
    }
    
}
