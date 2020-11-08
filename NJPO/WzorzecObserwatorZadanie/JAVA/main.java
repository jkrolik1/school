import java.util.InputMismatchException;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        showTemp();
    }
    static void showTemp(){
        CzyjnikTemperatury table = new CzyjnikTemperatury();

        addObserver(table);

        try{ table.setTemperature(getTemp()); }
        catch(NullPointerException npe) { System.out.print(""); }
    }
    static Double getTemp(){
        try{
            Scanner scan = new Scanner(System.in);
            System.out.print("Your temperature in celsius to convert: ");
            return scan.nextDouble();
        }
        catch(InputMismatchException ex)    { System.out.print("\nEnter number!\n"); }
        return null;
    }
    static void addObserver(CzyjnikTemperatury x){
        CelsiusScale cs = new CelsiusScale(x);
        KelvinScale ks = new KelvinScale(x);
        FahrenheitScale fs = new FahrenheitScale(x);

        x.addObserver(cs);
        x.addObserver(ks);
        x.addObserver(fs);
    }
}
