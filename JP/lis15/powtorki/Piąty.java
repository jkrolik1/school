/*
Proszę napisać program, ktory zamieni wszy pierwze 
litery slow wystepujacych po kropce na duze
np s1 = "Ala ma kota. bolek ma psa."
   s2 = "Ala ma kota. Bolek ma psa."
 */
package lis15.powtorki;

public class Piąty {

    public static void main(String[] args) {
        String s1="Ala ma kota. bolek ma psa.";
        String literka;
        String duza;
        String koniec="";
        for(int i=0; i<s1.length()-1; i++){
            if(s1.charAt(i)=='.'){
                if(s1.charAt(i+1)==' '){
                    literka=s1.substring(i+2,i+3);
                    duza=literka.toUpperCase();
                    StringBuffer sb=new StringBuffer(s1);
                    sb.replace(i+2,i+3,duza);
                    koniec=sb.toString();
                }    
            }
        }
        System.out.print(koniec);
    }
    
}
