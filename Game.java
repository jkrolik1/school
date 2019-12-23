import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Game{
    private Player player;
    private List<Player> players = new ArrayList();
    Random dice = new Random();
    
    public void addPlayer(Player player){
        this.player = player;
        players.add(player);
    }
    
    public void play(){
        int number;
        int guess;
        
        boolean repeat;
        
        do{
            repeat = true;                          //po to aby kazdy gracz mogl
            
            number = dice.nextInt(6)+1;
            System.out.println("Wylosowana: " + number);
            
            
            for(Player player : players){
                
                guess = player.guess();
                System.out.println("Odgadywana: " + guess);

                if(number!=guess){
                    System.out.println("Źle " + player.getName() + "! Spróbuj ponownie.");
                    System.out.println("");
                }else{
                    System.out.println("Brawo " + player.getName() + "!");
                    repeat=false;
                }
                
            }

        }while(repeat);
    }
}
