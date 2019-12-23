import java.util.Scanner;
public class PlayerHuman extends Player{
    private Scanner scanner = new Scanner(System.in);
    public PlayerHuman(){}
    public PlayerHuman(String name){
        super(name); 
    }
    @Override
    public int guess(){
        return scanner.nextInt();
    }
}
