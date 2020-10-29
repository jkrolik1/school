/*
Proszę napisać program, który policzy ile slow wystepujacych 
w zdaniu rozpoczyna sie duza litera
 */
package lis15;


public class Łańcuchy_program1 {


    public static void main(String[] args) {
        String s1 = "Ala ma psa Fafika";
        s1 = " "+s1;
        String literka;
        int licz=0;
        for(int i=0; i<s1.length(); i++){
            if(s1.charAt(i)==' '){
                literka = s1.substring(i+1,i+2);
                if((literka).toUpperCase().equals(literka))
                    licz++;
            }   
        }
        
        s1 = s1.trim();
        licz = 0;
        String tab[] = s1.split(" ");
        for(int i=0; i<tab.length; i++){
            literka = tab[i].substring(0, 1);
            if ((literka).toUpperCase().equals(literka)) {
                licz++;
            }
        }
        
        System.out.println(licz);
    }

}
