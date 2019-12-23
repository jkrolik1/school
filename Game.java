import java.util.Random;
public class Game{
    private Player player;
    Random dice = new Random();
    
    public void addPlayer(Player player){
        this.player = player;                   //inaczej bd nullpointerexception
    }
    public void play(){
        int number;
        int guess;
        do{
           number = dice.nextInt(6)+1;
           System.out.println("Wylosowana: " + number);
           guess = player.guess();
           System.out.println("Odgadywana: " + guess);
           if(number!=guess){
               System.out.println("Źle " + player.getName() + "! Spróbuj ponownie.");
               System.out.println("");
           }
        } while(number!=guess);
        System.out.println("Brawo " + player.getName() + "!");
    }
}
