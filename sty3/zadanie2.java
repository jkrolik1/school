/*
program ktory w kolejnych wierszach pliku txt wpisze liczby (10) calk od 1 do 49
 */
package sty3;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.Random;
public class zadanie2 {
    public static void main(String[] args) {
        int a = 1;
        int b = 49;
        int losowa;
        Random r = new Random();
        try{
            PrintWriter pw = new PrintWriter(new FileWriter("liczby.txt",true),true);
            for(int i=0; i<10; i++){
                pw.println(r.nextInt(b-a+1)+a);
            }
            pw.close();
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
}    



