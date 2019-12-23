import java.util.HashMap;
import java.util.Map;

public class Statistics {
    
    private Map<Player, Integer> stats = new HashMap();
    
    public void andTheWinnerIs(Player player){
        int score = stats.getOrDefault(player,0);           //domyslna wartosc, na poczatku mapa jest pusta
        score += 1;
        stats.put(player,score);
    }    
    
    public void print(){
        System.out.println("\n#########################");
        System.out.println(stats);
    }
    
    public void clear(){
        
    }
    
}
