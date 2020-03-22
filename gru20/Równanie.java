// zadanie z egzaminu f kwadratowa
package gru20;
public class Równanie {
    private int a,b,c;
    private int x1,x2;
    Równanie(int a, int b, int c){                      // konstruktor!!!
        this.a = a;
        this.b = b;
        this.c = c;
    }
    public int oblicz(int x){
        int y=0;
        y=a*x*x+b*x+c;
        return y;
    }
    public int pierwiastki(){
        int delta;
        delta = b*b-4*a*c;
        if(delta>0) return 2;
        else if(delta==0) return 1;
        else if(delta<0) return 0;
        return 0;
    }
}
