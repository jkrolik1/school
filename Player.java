public abstract class Player {         
    private String name="Anonim";               
    public Player(){}                                   
    public Player(String name){
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
    public abstract int guess();
}
