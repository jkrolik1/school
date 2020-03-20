public class BaseUnit extends ReferenceUnit{
    public BaseUnit(String name, String type){
        super(name,type);
    }

    @Override
    public void showInfo() {
        System.out.println(type + ": " + name);
    }
}
