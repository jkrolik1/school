import java.util.Random;
import java.util.*;

public class Random1 {
    public static void main(String[] args) {
        
        Game game = new Game();
        Player player = new PlayerComp("Janusz");

        game.addPlayer(player);
        game.play();
    }
}