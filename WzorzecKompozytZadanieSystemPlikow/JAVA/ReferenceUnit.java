public abstract class ReferenceUnit {
    public ReferenceUnit(String name, String type){
        setName(name);
        setType(type);
    }

    void setName(String name)   { this.name = name; }
    void setType(String type)   { this.type = type; }
    String getName()    { return name; }
    String getType()    { return type; }

    public abstract void showInfo();
    public abstract boolean findObjB(String str);
    public abstract ReferenceUnit findObj(String str);
    protected String name;
    protected String type;
}
