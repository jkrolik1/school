import java.util.Random;

public class Player {
    private Random dice = new Random();         //pole klasy
    private String name;
  //private String name="Anonim";               może zamiast konstruktora bezparametrowego wtedy public Player() {}
    public Player(){
        //this.name="Anonim";                   //raczej nie!!!
        setName("Anonim");
    }                                           //ta sama nazwa funkcji np: dla konstruktora to PRZECIĄŻENIE
    public Player(String name){
        //this.name=name;                       //raczej nie!!!
        setName(name);
    }
    public void setName(String name){           //setter!!!!!!
        if(name!=null && !(name.isEmpty())){    //muszą być oba prawdziwe (Ważna kolejność!!!)
      //if(name!=null && name.length!=0)          
      //if(name!=null && !(name.equals("")))          
      //if(name!=null && !("".equals(name)))         
      //if(name!=null && name!="")              //nie!!!
            this.name=name;
        }
        else{
            System.err.println("Podaj prawidłowe imię");
        }
        
    }
    public String getName(){
        return name;
    }
    public int guess(){
        return dice.nextInt(6)+1;
    }
}