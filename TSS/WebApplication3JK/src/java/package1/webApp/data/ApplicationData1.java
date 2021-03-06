package package1.webApp.data;

import package1.webApp.model.Battle;
import package1.webApp.model.Tank;

public class ApplicationData1 {
    java.util.List<Tank> listOfTanks = new java.util.ArrayList();
    java.util.List<Battle> listOfBattles = new java.util.ArrayList();
    
    public boolean addTank(String name, String country, int armorAmount, int gunCaliber){
        if(!(name.isEmpty()) && (!(country.isEmpty())) && (!(armorAmount==0)) && (!(gunCaliber==0))){
            Tank tank = new Tank(0,name,armorAmount,gunCaliber);
            listOfTanks.add(tank);
        }
        else
            return false;

        return true;
    }
    public void deleteTank(int index){
        if(index >= 0)
            listOfTanks.remove(index);
    }
    public String getTankNameAndDetails(int index){
        if(index >= 0){
            Tank tank = listOfTanks.get(index);
            String tankInfo = 
                    tank.getName() + " | " + 
                    tank.getArmorAmount() + " | " + 
                    tank.getGunCaliber();
            return tankInfo;
        }
        else
            return "No info";
    }
    public java.util.List<Tank> listOfTanks(String name){return listOfTanks;}
    
    public static String battleFight(Tank tank1, Tank tank2){
        Battle battle = new Battle();
        String battleScore = battle.battleInitiate(tank1, tank2);
        return battleScore;
    }
}
