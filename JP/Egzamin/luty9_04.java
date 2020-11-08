package Egzamin;
import java.io.RandomAccessFile;
import java.io.IOException;
public class luty9_04 {
    public static void main(String[] args) {}
    public void Emerytura(String plik){
        String s;
        String imie,nazwisko,płeć;
        int wiek,różnica;
        String[] tab = null;
        try{
            RandomAccessFile raf = new RandomAccessFile(plik,"rw");
            RandomAccessFile kob = new RandomAccessFile("kobiety.bin","rw");
            RandomAccessFile men = new RandomAccessFile("mezczyzni.bin","rw");
            do{
                s = raf.readUTF();
                tab = s.split("-");
                imie = tab[0];
                nazwisko = tab[1];
                płeć = tab[2];
                wiek = Integer.parseInt(tab[3]);
                if(imie.contains("a")){
                    if((imie.indexOf('a'))==imie.length()){
                        //kobieta
                        if(wiek>65){
                            różnica = 0;
                            kob.writeUTF(nazwisko);
                            kob.writeInt(różnica);
                        }
                        else if(wiek<65){
                            różnica = 65 - wiek;
                            kob.writeUTF(nazwisko);
                            kob.writeInt(różnica);
                        }
                        else if(wiek==65){
                            różnica = 0;
                            kob.writeUTF(nazwisko);
                            kob.writeInt(różnica);
                        }
                    }
                    else{
                        //men
                        if(wiek>67){
                            różnica = 0;
                            men.writeUTF(nazwisko);
                            men.writeInt(różnica);
                        }
                        else if(wiek<67){
                            różnica = 67 - wiek;
                            men.writeUTF(nazwisko);
                            men.writeInt(różnica);
                        }
                        else if(wiek==67){
                            różnica = 0;
                            men.writeUTF(nazwisko);
                            men.writeInt(różnica);
                        }
                    }
                }
                else{
                    //men
                        if(wiek>67){
                            różnica = 0;
                            men.writeUTF(nazwisko);
                            men.writeInt(różnica);
                        }
                        else if(wiek<67){
                            różnica = 67 - wiek;
                            men.writeUTF(nazwisko);
                            men.writeInt(różnica);
                        }
                        else if(wiek==67){
                            różnica = 0;
                            men.writeUTF(nazwisko);
                            men.writeInt(różnica);
                        }
                }
            }while(raf.getFilePointer()<raf.length());
            raf.close();
            kob.close();
            men.close();
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
    
}
