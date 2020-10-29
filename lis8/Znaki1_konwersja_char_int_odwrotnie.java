
package lis8;


public class Znaki1_konwersja_char_int_odwrotnie {

    
    public static void main(String[] args) {
        char znak; //2bajty
        int kod_znaku; //4bajty
        
        znak='a';
        kod_znaku=(int)znak; //rzutowanie
        
        //odwrotna konwersja nie zachodzi (konwersja stratna)
        znak=(char)kod_znaku;
        
        System.err.println(znak+" "+kod_znaku);
    }
    
}
