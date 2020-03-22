// przestawia literki w co 3 wyrazie 
package Egzamin;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;
public class luty10_02 {
    public static void main(String[] args) {
        String s,s2;
        String[] tab;
        String odwr="";
        try{
            BufferedReader plik = new BufferedReader(new FileReader("a_moje1.txt"));
            do{
                s = plik.readLine();
                if(s!=null){
                    tab = s.split(" ");
                    for(int i=0; i<tab.length; i++){
                        if((i+1)%3==0){
                            s2 = tab[i];
                            for(int p=0; p<s2.length(); p++){
                                odwr = s2.charAt(p) + odwr;
                            }
                            System.out.println(odwr);
                            odwr="";
                        }
                    }
                }
            }while(s!=null);
            plik.close();
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
}
