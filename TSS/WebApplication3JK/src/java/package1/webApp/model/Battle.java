package package1.webApp.model;

import java.time.LocalDate;

public class Battle {
    private int battleNumber;
    private String start;
    
    public Battle(){}
    public Battle(int battleNumber){
        this.battleNumber = battleNumber;
        this.start = new java.util.Date().toLocaleString();
    }
    public String battleInitiate(Tank tank1, Tank tank2){
        int tank1armorAmount = tank1.getArmorAmount();
        int tank1gunCaliber = tank1.getGunCaliber();
        
        int tank2armorAmount = tank2.getArmorAmount();
        int tank2gunCaliber = tank2.getGunCaliber();
        
        int powerTank1 = tank1armorAmount*tank1gunCaliber;
        int powerTank2 = tank2armorAmount*tank2gunCaliber;
        
        if (powerTank1 > powerTank2)
            return "Wygrał czołg "+tank1.getName();
        else if (powerTank1 < powerTank2)
            return "Wygrał czołg "+tank2.getName();
        else
            return "Remis";
    }
}
