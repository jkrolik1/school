public class BaseUnit extends ReferenceUnit{
    public BaseUnit(String name, String type){
        super(name,type);
    }

    @Override
    public void showInfo() {
        System.out.println(type + ": " + name);
    }
    @Override
    public boolean findObjB(String str) { return false; }
    @Override
    public ReferenceUnit findObj(String str) { return null; }
}
