import java.util.Scanner;

public class mainProg {
    public static void main(String[] args) {
        myStructure();

    }
    static void myStructure(){
        String fromUsr, path = "C:\\home", foldName = "";

        OrganizeUnit home = new OrganizeUnit("home","Folder");
        OrganizeUnit komputer = new OrganizeUnit("komputer","Folder");
        OrganizeUnit agd = new OrganizeUnit("agd","Folder");
        OrganizeUnit rtv = new OrganizeUnit("rtv","Folder");
        home.add(komputer);
        home.add(agd);
        home.add(rtv);

/*        OrganizeUnit ou1 = new OrganizeUnit("Komputer","Folder");
        OrganizeUnit ou2 = new OrganizeUnit("Laptop","Podfolder");
        OrganizeUnit ou3 = new OrganizeUnit("PC","Podfolder");
        ou1.add(ou2);
        ou1.add(ou3);
        ou2.add(new BaseUnit("ASUS","Plik 1"));
        ou2.add(new BaseUnit("Lenovo","Plik 2"));
        ou1.showInfo();*/
        do{
            fromUsr = fromUser(path);
            if(fromUsr.equals("dir")){
                foldName = findPartOfStr(path);
                if(xxx.getName().equals(home.getName()))
                a.showInfo();
            }

        }while(!(fromUsr.equals("exit")));
    }

    static String fromUser(String path){
        String userLine = "";
        Scanner scan = new Scanner(System.in);
        System.out.print(path + "> ");
        userLine = scan.nextLine();
        return userLine;
    }

    static String findPartOfStr(String path){
        String retStr = "";
        int index=0;

        for(int i=0; i>path.length()-1; i++)
            if(path.charAt(i) == '\\')
                index = i;

        for(int j=index; j>path.length()-1; j++)
            retStr += path.charAt(j);
        return retStr;
    }

    static String findObj(String str){
        
    }
}
