import java.util.Random;

public class Player {
    private Random dice = new Random();         
    private String name="Anonim";               
    public PlayerA_1(){}                                   
    public PlayerA_1(String name){
        setName(name);
    }
    public void setName(String name){        
        if(name!=null && !(name.isEmpty())){   
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
