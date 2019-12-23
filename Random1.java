import java.util.Random;
import java.util.*;

public class Random1 {
    public static void main(String[] args) {
        
        Player player = new PlayerComp("Janusz");
        
        List<String> list = new ArrayList();
        
        list.add("raz");
        list.add("dwa");        // int -> Integer
        list.add("trzy");
        
        System.out.println(list.toString());
        System.out.println("-------------");
        
        for(int i=0; i<list.size(); ++i){
            System.out.println(list.get(i));
        }
        System.out.println("-------------");
        
        for(String s : list){
            System.out.println(s);
        }
        System.out.println("-------------");  
        
//      Iterator<String> it = list.iterator();  //zbyt duzy zasieg zmiennej
//      while(it.hasNext()){
//          System.out.println(it.next());
//      }
        System.out.println("-------------");  
        
        for(Iterator<String> it = list.iterator(); it.hasNext(); ){
            System.out.println(it.next());
        }
        
//      Iterator<String> itt = list.iterator();
//      while(true){                            // NoSuchElementException
//      System.out.println(it.next());
//      }
        
        
        /*
        Game game = new Game();
        Player player = new PlayerComp("Janusz");

        game.addPlayer(player);
        game.play();
        */
    }
}