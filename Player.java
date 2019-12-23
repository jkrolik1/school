package Lesson2;

import java.util.Random;

public class Player {
    private Random dice = new Random();             //pole klasy
    private String name;
    public void setName(String name){               //setter!!!!!!
        if(name!=null){
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
