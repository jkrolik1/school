package Egzamin;
public class luty9_01 {
    public static void main(String[] args) {}  
}
class Funkcja{
    private final double a, b, c;
    double y, delta;
    public Funkcja(double a,double b,double c){
        this.a=a;
        this.b=b;
        this.c=c;
    }
    public double funkcja2(double x){
        y = a*x*x + b*x + c;
        return y;
    }
    public int pierwiastki(){
        final double x1, x2;
        delta = b*b-4*a*c;
        x1 = (-b-(Math.pow(delta,1/2)))/2*a;
        x2 = (-b+(Math.pow(delta,1/2)))/2*a;
        if(delta>0) return 2;
        if(delta==0) return 1;
        if(delta<0) return 0;
        return 0;
    }
}
