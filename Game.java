import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class Game{
    private Player player;
    private List<Player> players = new ArrayList();
    Random dice = new Random();
    
    public void addPlayer(Player player){
        String s = "";
        int i = 1;

        for(int k=0; k<players.size(); ++k) {
            for(Player p : players) {
                if(p.getName().equals(player.getName() + s)) {
                    s = String.valueOf(i++);
                }
            }
        }

        player.setName(player.getName() + s);
        players.add(player);
    }

    public void printPlayers(){
        System.out.println("Lista graczy: ");
        for(Player player1:players){
            System.out.println(player1.getName()+" ");
        }
        System.out.println();
    }

    public void removePlayer(String name){
        for(Iterator<Player> it = players.iterator(); it.hasNext();){
            if(it.next().getName().equals(name))
                it.remove();
        }
    }

    public void play(){
        int number;
        int guess;
        
        boolean repeat;


        printPlayers();


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
