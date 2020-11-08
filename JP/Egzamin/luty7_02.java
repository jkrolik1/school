package Egzamin;
import java.util.Random;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.io.IOException;
public class luty7_02 {
    public static void main(String[] args) {
        Random r = new Random();
        int[][] tablica1 = null;
        String[] tablica2 = null;
        int a = 'a';
        int b = 'z';
        int licz = 0;
        String s;
        char s1;
        try{
            FileWriter plik1 = new FileWriter("a_moje1.txt",true);
            FileWriter plik3 = new FileWriter("a_moje2.txt",true);
            BufferedReader plik2 = new BufferedReader(new FileReader("a_moje1.txt"));
            tablica1 = new int[10][10];
            for(int w=0; w<10; w++){
                for(int k=0; k<10; k++){
                    tablica1[w][k] = r.nextInt(b-a+1)+a;
                }
            }
            for(int w=0; w<10; w++){
                for(int k=0; k<10; k++){
                    plik1.write(tablica1[w][k]+" ");
                }
                plik1.write("\n");
            }
            
            do{
                s=plik2.readLine();
                if((s!=null)&&(licz%2!=0)){
                    tablica2 = s.split(" ");
                    for(int i=0; i<10; i++){
                        if(i%2!=0){
                            plik3.write(tablica2[i]+" ");
                        }
                    }
                }
                licz++;
            }while(s!=null);
            
            plik1.close();
            plik2.close();
            plik3.close();
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
    
}
