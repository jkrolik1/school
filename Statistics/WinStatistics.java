package Statistics;

import players.Player;
import java.util.HashMap;
import java.util.Map;

public class WinStatistics implements Statistics{
    
    private Map<Player, Integer> stats = new HashMap();
    
    public void andTheWinnerIs(Player player){
        int score = stats.getOrDefault(player,0);                               //domyslna wartosc, na poczatku mapa jest pusta
        score += 1;
        stats.put(player,score);
    }    
    
    public void print(){
        
        System.out.println("\n#########################");
        
        for(Player player : stats.keySet()){                                    //iteracja po kluczach
            System.out.println(player.getName() + ": " + stats.get(player));
        }
        
        System.out.println("\n************************");
        
        stats.forEach((Player player, Integer score) -> 
                System.out.println(player.getName() + ": " + score));
    }
    
    public void clear(){
        stats.clear();
    }
    
}
