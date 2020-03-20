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
    public void showInfo() {
        System.out.println(type + ": " + name);
        for(ReferenceUnit y : components){
            System.out.print(" ");
            y.showInfo();
        }
    }
}
