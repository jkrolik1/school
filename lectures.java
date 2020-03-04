public class lectures {
    public static void main(String[] args) {

        singeltonStatic();

    }
    static void singeltonStatic() {
        System.out.println(Singelton.getInstance());
        System.out.println(Singelton.getInstance());
    }

}
class Singelton{
    private static Singelton instance = null;
    private Singelton(){}
    public static Singelton getInstance(){
        if(instance == null)
            instance = new Singelton();

        return instance;
    }
}
