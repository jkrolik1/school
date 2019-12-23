import java.util.Random;
public class Random1 {
    public static void main(String[] args) {
        Random dice = new Random();
        
        Player player = new PlayerComp();
        
        try{
            player.setName("Ma~");
        }
        catch(IllegalArgumentException ex){
            System.err.println("Błąd! " + ex.getMessage());
        }
        
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
