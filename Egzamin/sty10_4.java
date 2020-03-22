/*
    4) ile razy liczba a poprzedza liczbe c
 */
package Egzamin;
import java.io.PrintWriter;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
public class sty10_4 {
    public static void main(String[] args) {
        int kod_znaku,licz=0,liczba=0,tak=0;
        char znak;
        boolean flaga = false;
        try{
            FileReader fr = new FileReader("kk.txt");
            do{
                kod_znaku = fr.read();
                znak = (char)kod_znaku;
                if(znak=='a') {
                    flaga=true;
                    licz=liczba;
                }
                if(flaga&&(licz==(liczba+1))){
                    if(znak=='c')tak++;
                }
                licz++;
            }while(kod_znaku!=-1);
            System.out.println(tak);
            fr.close();
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
    
}
