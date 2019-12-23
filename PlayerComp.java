import java.util.Random;

public class PlayerComp extends Player {
    private Random brain = new Random();
    @Override
    public int guess(){
        return brain.nextInt(6)+1;
    }
}
