public class Random1 {
    public static void main(String[] args) {
        
        Game game = new Game();
        
        game.addPlayer(new PlayerComp("Janusz"));
        game.addPlayer(new PlayerComp("Janusz"));
        
        game.play();
        
    }
}