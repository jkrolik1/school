package Projekt;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class www {

    public static void main(String[] args) {
        FileReader fr = null;
        String linia,linia2 = "";
        StringBuffer sb;
        try{
            fr = new FileReader("zwierzeta.dat");
            BufferedReader bfr = new BufferedReader(fr);
            linia = (bfr.readLine()).trim();
            for(int i=0; i<linia.length(); i++){
                if(linia.charAt(i)==' '){
                    if(linia.charAt(i+1)==' '){
                        sb = new StringBuffer(linia);
                        sb.delete(i, i+1);
                        linia2 = sb.toString();
                    }         
                }   
            }
            //String tab[] = linia2.split(" ");
            System.out.print(linia+""+linia2);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    
}
