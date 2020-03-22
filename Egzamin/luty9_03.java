package Egzamin;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;
public class luty9_03 {
    public static void main(String[] args) {
        String s, łańcuch=null, wszy;
        String[] tab;
        int a = 'a';
        int z = 'z';
        int zmienna=0, znak=0, poprawność=-1;
        try{
            BufferedReader br = new BufferedReader(new FileReader("a_moje1.txt"));
            do{
                s = br.readLine();
                if(s!=null){
                    tab = s.split(" ");
                    łańcuch = tab[0];
                    for(int i=0; i<łańcuch.length(); i++){
                        if(łańcuch.charAt(i)=='a') zmienna++;
                        if(łańcuch.charAt(i)=='b') zmienna++;
                        if(łańcuch.charAt(i)=='c') zmienna++;
                        if(łańcuch.charAt(i)=='+') znak++;
                        if(łańcuch.charAt(i)=='-') znak++;
                        if(łańcuch.charAt(i)=='*') znak++;
                        if(łańcuch.charAt(i)=='/') znak++;
                    }
                    if((zmienna-1)==znak) poprawność = 1;
                    else poprawność = 0;
                }
            }while(s!=null);
            StringBuffer sb = new StringBuffer(łańcuch);
            sb.append(" ");
            sb.append(poprawność);
            wszy = sb.toString();
            PrintWriter pw = new PrintWriter(new FileWriter("a_moje1.txt",false),false);
            pw.println(wszy);
            br.close();
            pw.close();
            System.out.println(a);
            System.out.println(z);
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
    
}
