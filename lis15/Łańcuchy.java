package lis15;




public class Łańcuchy {


    public static void main(String[] args) {
        String s1,s2,s3,s4,s5,s6,s7;            //typ obiektowy z duzej
        String s8,s9,s10,s11,s12,s13,s14;       //typ obiektowy z duzej
        s1 = "Ala ma kota i ma psa";
        s2 = s1.toUpperCase();                  //male na duze
        s3 = s1.toLowerCase();                  
        s4 = s1.trim();                         //kasuje poczatkowe i koncowe spacje
        s5 = s1.substring(4);                   //wycina od 4
        s6 = s1.substring(4, 6);                //wycina od 4 do 6 - pokaze 6-4=2 literki 4-pierwsza literka
        s7 = s1.replace("ma", "nie ma");        //zastapienie "ma" na "nie ma"
        s8 = s1.replaceFirst("ma", "nie ma");   //tylko pierwsze "ma" drugiego nie
        int i = s1.length();                    //dlugosc lancucha
        char c = s1.charAt(4);                  //wycina znak              
        boolean b = s1.equals(s2);              //spr czy lancuchy sa rowne              
        int q = s1.indexOf("ma");               //indeks pierwszego wystapienia "ma"
        int w = s1.lastIndexOf("ma");           //indeks ostatniego wystapienia "ma"
        
        if(s1.contains("coś"))          // true lub false
            
        
        
        System.out.println(b); 
        
        //------------------------------------------------------------------------------
        
        String tab[] = s1.split(" ");           //wyszukanie w s1 fragm oddzielone spacja i przerzuca do tablicy 
        System.out.println(tab[2]);                  
        System.out.println(tab[3]);  
        
    //  Arrays.sort();
        
        //------------------------------------------------------------------------------
        
        StringBuffer sb = new StringBuffer(s1);     //przeksztalcenie s1 do stringbuffer
        sb.delete(4, 6);
        sb.insert(4, "nie ma");
        sb.replace(4, 7, "ma");
        sb.reverse();
        sb.append("coś co chce dołączyć na koniec");
        s11 = sb.toString();
        System.out.println(s11);

    }
    
}
