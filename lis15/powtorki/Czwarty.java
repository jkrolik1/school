/*
Proszę napisać program, który policzy ile slow wystepujacych 
w zdaniu rozpoczyna sie duza litera
 */
package lis15.powtorki;

public class Czwarty {

    public static void main(String[] args) {
        String s2="Informatyka to Trudna dziedzina";
        String s1 = " "+s2;
        String literka;
        int licz=0;
        for(int i=0; i<s1.length(); i++){
            if(s1.charAt(i)==' '){
                literka=s1.substring(i+1,i+2);
                if(literka.toUpperCase().equals(literka))
                    licz++;
            }
        }
        System.out.print(licz);
    }
}
    

