/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package package1.webApp.model;

/**
 *
 * @author Jakub
 */
public class Tank {
    private String name;
    private String country;
    private int armorAmount;
    private int gunCaliber;
    
    public Tank(String name, String country, int armorAmount, int gunCaliber){
        setName(name);
        setCountry(country);
        this.armorAmount = armorAmount;
        this.gunCaliber = gunCaliber;
    }
    
    public void setName(String name){
        if (!name.isEmpty())
            this.name = name;
    }
    public void setCountry(String country){
        if (!country.isEmpty())
            this.country = country;
    }
    public void setArmorAmount(int armorAmount){
        this.armorAmount = armorAmount;
    }
    public void setGunCaliber(int gunCaliber){
        this.gunCaliber = gunCaliber;
    }

    public String getName(){
        return name;
    }
    public String getCountry(){
        return country;
    }
    public int getArmorAmount(){
        return armorAmount;
    }
    public int getGunCaliber(){
        return gunCaliber;
    }
}
