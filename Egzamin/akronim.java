package Egzamin;

public class akronim {
    static void akronim(String s){
        String akronim="";
        double dzielnik=0, dzielna=0;
        int licznik_dzielnik=0, licznik_dzielna=0;
        double dzialanie=0;
        boolean jest_liczba = false;
        String[] tab = s.split(" ");
        for(int i=0; i<tab.length; i++){
            if((!(tab[i].contains("0")))&&
            (!(tab[i].contains("1")))&&
            (!(tab[i].contains("2")))&&
            (!(tab[i].contains("3")))&&
            (!(tab[i].contains("4")))&&
            (!(tab[i].contains("5")))&&
            (!(tab[i].contains("6")))&&
            (!(tab[i].contains("7")))&&
            (!(tab[i].contains("8")))&&
            (!(tab[i].contains("9")))){
                akronim = akronim + tab[i].charAt(0);
                akronim = akronim.toUpperCase();
            }
            else{
                jest_liczba=true;
                akronim = akronim + " " + tab[i];
                for(int w=0; w<tab[i].length(); w++){
                    if(tab[i].charAt(w)=='1') {dzielnik = dzielnik + 1; licznik_dzielnik++;}
                    if(tab[i].charAt(w)=='3') {dzielnik = dzielnik + 3; licznik_dzielnik++;}
                    if(tab[i].charAt(w)=='5') {dzielnik = dzielnik + 5; licznik_dzielnik++;}
                    if(tab[i].charAt(w)=='7') {dzielnik = dzielnik + 7; licznik_dzielnik++;}
                    if(tab[i].charAt(w)=='9') {dzielnik = dzielnik + 9; licznik_dzielnik++;}
                    if(tab[i].charAt(w)=='0') {dzielna = dzielna + 0; licznik_dzielna++;}
                    if(tab[i].charAt(w)=='2') {dzielna = dzielna + 2; licznik_dzielna++;}
                    if(tab[i].charAt(w)=='4') {dzielna = dzielna + 4; licznik_dzielna++;}
                    if(tab[i].charAt(w)=='6') {dzielna = dzielna + 6; licznik_dzielna++;}
                    if(tab[i].charAt(w)=='8') {dzielna = dzielna + 8; licznik_dzielna++;}
                }
            }
        }
        if(jest_liczba){
            dzialanie = (dzielnik/licznik_dzielnik)/(dzielna/licznik_dzielna);
            akronim = akronim.trim() + ", stosunek cyfr, to " + dzialanie;
        }
        System.out.println("Akronim wyrażenia: "+akronim);
    }
    public static void main(String[] args) {
        akronim("Informatyka inżynierska 2015");
    }
    
}
