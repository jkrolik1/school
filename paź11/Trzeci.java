package paź11;


public class Trzeci {

    
    public static void main(String[] args) {
       
        String sx,sy,sz;
        int x, y, z;
        
        sx = "6.2";
        sy = "5";
        
            try{
                x = Integer.parseInt(sx);
                y = Integer.parseInt(sy);

                z = x + y;

                sz = Integer.toString(z);

                System.out.print(sz);
            }
            catch(Exception e){
                System.out.println("Przerwa na kawę...");
            }
        }
}
    

