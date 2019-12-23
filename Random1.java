public class Random1 {
    public static void main(String[] args) {
        
        Game game = new Game();
        
        game.addPlayer(new PlayerComp("Janusz"));
        game.addPlayer(new PlayerComp("Janusz"));

        for(int i=0;i<100;++i){
            game.play();
        }
        
        game.printStats();
        
    }
}