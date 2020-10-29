package Egzamin;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;
public class luty9_05 {
    public static void main(String[] args) {
        String s,s1;
        try{
            BufferedReader br = new BufferedReader(new FileReader("a_moje1.txt"));
            PrintWriter pw = new PrintWriter(new FileWriter("a_moje2.txt",true),true);
            do{
                s = br.readLine();
                if(s!=null){
                    if(s.contains("mocium panie")){
                        s1 = s.replace("mocium panie"," ");
                        pw.println(s1);
                    }
                    else{
                        pw.println(s);
                    }
                }
            }while(s!=null);
            br.close();
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
    
}
