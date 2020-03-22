package paź18;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Student
 */
public class Piaty {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        boolean x,y,z;
        int k=0, m=5;
        x = true; y = false;
        y = x || y;
        y = x && y;
        y = !x;
        z = (k!=m)&&(k>0);
        
        if(z)
            k=7;
        
    }
    
}
