package lis29;
public class Student extends Osoba{
    String nr_indeksu;
    
    Student(String imie, String nazwisko, String nr_indeksu){
        super(0,imie,nazwisko);
        this.nr_indeksu = nr_indeksu;                
    }
    
  
    void wypisz(){
      super.wypisz();
      System.out.println(this.nr_indeksu);
    }
    
}
