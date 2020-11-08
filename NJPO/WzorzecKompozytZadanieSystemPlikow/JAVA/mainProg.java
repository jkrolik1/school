import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class mainProg {
    public static void main(String[] args) {
        myStructure();

    }
    static void myStructure(){
        String fromUsr, path = "C:\\home\\agd", foldName = "", s = "";
        ReferenceUnit ru = null;
        Map<Integer, String> pathParts = new HashMap<>();

        OrganizeUnit home = new OrganizeUnit("home","Folder");
        OrganizeUnit agd = new OrganizeUnit("agd","Podfolder");
        OrganizeUnit rtv = new OrganizeUnit("rtv","Podfolder");
        home.add(agd);
        home.add(rtv);
        BaseUnit washingmachine = new BaseUnit("washingmachine","Plik");
        BaseUnit dishwasher = new BaseUnit("dishwasher","Plik");
        BaseUnit absorber = new BaseUnit("absorber","Plik");
        agd.add(washingmachine);
        agd.add(dishwasher);
        agd.add(absorber);
        BaseUnit dvd = new BaseUnit("dvd","Plik");
        BaseUnit tv = new BaseUnit("tv","Plik");
        rtv.add(dvd);
        rtv.add(tv);

        System.out.println("\nCommands to use: tree | cd .. | cd/ | cd [nazwa folderu] | exit ");
        System.out.println("First default catalog: \"C:\\home\" \n");

        do{
            fromUsr = fromUser(path);
            if(fromUsr.equals("tree")){
                foldName = findPartOfStr(path);
                if(home.findObjB(foldName)){
                    ru = home.findObj(foldName);
                    ru.showInfo();
                }
                else
                    home.showInfo();
            }
            else if(fromUsr.equals("cd ..")){
                foldName = findPartOfStr(path);
                if(!(foldName.equals("home"))){
                    path = newPath(path);
                }
            }
            else if(fromUsr.equals("cd/")) {
                path = "C:\\home";
            }
            else if(fromUsr.length()>1) {
                try{
                    if (fromUsr.substring(0,4).equals("cd C")) {
                        if (fromUsr.equals("cd C:\\home"))
                            path = "C:\\home";
                        pathParts = findEverythingBetweenBS(fromUsr);
                        if (ifAllCreated(pathParts, home))
                            path = fromUsr.substring(3);
                    }
                }
                catch(StringIndexOutOfBoundsException ex){
                    System.out.println("\"" + fromUsr + "\" is not recognized");
                }
            }
            else if(fromUsr.equals("exit")) {}
            else
                System.out.println("\"" + fromUsr + "\" is not recognized");

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

        for(int i=0; i<path.length(); i++) {
            if (path.charAt(i) == '\\'){
                index = i+1;
            }
        }

        for(int j=index; j<path.length(); j++)
            retStr += path.charAt(j);
        return retStr;
    }

    static String newPath(String oldPath){
        String newPath = "";
        int index = 0;

        for(int i=0; i<oldPath.length(); ++i)
            if(oldPath.charAt(i)=='\\')
                index = i;

        newPath = oldPath.substring(0,index);

        return newPath;
    }

    static Map<Integer, String> findEverythingBetweenBS(String path){
        Map<Integer, String> everythingStr = new HashMap<>();
        int i,key;
        String s = "";

        for(i=0,key=0; i<path.length(); ++i){
            if(path.charAt(i) == 'C'){
                if(path.charAt(i+1) == ':'){
                    i += 1;
                    continue;
                }
            }
            else if(path.charAt(i) != '\\') {
                s = everythingStr.getOrDefault(key, "");
                s += path.charAt(i);
                everythingStr.put(key, s);
            }
            else if(path.charAt(i) == '\\')
                key += 1;
        }
        return everythingStr;
    }

    static boolean ifAllCreated(Map<Integer, String> pathParts, OrganizeUnit home){
        String s = "";

        for(int x : pathParts.keySet())
            s = pathParts.getOrDefault(x,"");
            if(s != "home"){
                if(!(home.findObjB(s)))
                    return false;
        }
        return true;
    }

}
