package Egzamin;
class funkcja{
    private int a,b,c;
    double delta;
    private double x1,x2;
    funkcja(int a, int b, int c){
        this.a = a;
        this.b = b;
        this.c = c;
    }
    public int wartosc(int x){
        int y=0;
        y=a*x*x+b*x+c;
        return y;
    }
    int liczba(){
        delta = b*b-4*a*c;
        if(delta>0) {
            x1=(-b-Math.sqrt(delta))/2*a;
            x2=(-b+Math.sqrt(delta))/2*a;
            return 2;
        }
        else if(delta<0) {
            x1=x2=(-b-Math.sqrt(delta))/2*a;
            return 1;
        }
        else if(delta==0) return 0;    
        return 0;
    }
}
