import java.util.ArrayList;

public class OrganizeUnit extends ReferenceUnit{
    protected ArrayList<ReferenceUnit> components = new ArrayList();
    public OrganizeUnit(String name, String type){
        super(name,type);
    }
    public void add(ReferenceUnit x){
        components.add(x);
    }
    @Override
    public boolean findObjB(String str){
        for(ReferenceUnit z : components){
            if(z.getName().equals(str)){
                return true;
            }
        }
        return false;
    }
    @Override
    public ReferenceUnit findObj(String str){
        for(ReferenceUnit p : components){
            if(p.getName().equals(str)){
                return p;
            }
        }
        return null;
    }
    @Override
    public void showInfo() {
        System.out.println(type + ": " + name);
        for(ReferenceUnit y : components){
            if((y.getType()) == "Podfolder"){
                System.out.print("  ");
            }
            if((y.getType()) == "Plik"){
                System.out.print("   ");
            }
            System.out.print(" ");
            y.showInfo();
        }
    }
}
