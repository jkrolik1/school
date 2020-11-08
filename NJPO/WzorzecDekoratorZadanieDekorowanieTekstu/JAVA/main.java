import decorators.*;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        text1();
    }

    static void text1(){
        String s = getText();
        boolean one = false, two = false, three = false, four = false;

        ArrayList<Integer> parts;
        parts = choseTags();

        System.out.print("\nTAGGED TEXT: ");

        if(parts.size() == 4){
            PlainText x = new ParagraphDecorator(new StrongDecorator(new EmphasizedDecorator(new MarkDecorator(new Text(s)))));
            x.write();
            System.out.println("");
        }
        else if(parts.size() == 1){
            for(int o : parts){
                if(o == 1){
                    PlainText p = new ParagraphDecorator(new Text(s));
                    p.write();
                    System.out.println("");
                }
                else if(o == 2){
                    PlainText st = new StrongDecorator(new Text(s));
                    st.write();
                    System.out.println("");
                }
                else if(o == 3){
                    PlainText em = new EmphasizedDecorator(new Text(s));
                    em.write();
                    System.out.println("");
                }
                else if(o == 4){
                    PlainText p = new ParagraphDecorator(new Text(s));
                    p.write();
                    System.out.println("");
                }
            }

        }
        else {
            if(parts.size() == 0){ System.out.println(s); }
            else{
                for(int o : parts){
                    if(o == 1)  one = true;
                    if(o == 2)  two = true;
                    if(o == 3)  three = true;
                    if(o == 4)  four = true;
                }
                if(parts.size() == 2) {
                    if(one && two && !three && !four){
                        PlainText x = new ParagraphDecorator(new StrongDecorator(new Text(s)));
                        x.write();
                        System.out.println("");
                    }
                    else if(one && !two && three && !four){
                        PlainText x = new ParagraphDecorator(new EmphasizedDecorator(new MarkDecorator(new Text(s))));
                        x.write();
                        System.out.println("");
                    }
                    else if(one && !two && !three && four){
                        PlainText x = new ParagraphDecorator(new MarkDecorator(new Text(s)));
                        x.write();
                        System.out.println("");
                    }
                    else if(!one && two && three && !four){
                        PlainText x = new StrongDecorator(new EmphasizedDecorator(new Text(s)));
                        x.write();
                        System.out.println("");
                    }
                    else if(!one && two && !three && four){
                        PlainText x = new StrongDecorator(new MarkDecorator(new Text(s)));
                        x.write();
                        System.out.println("");
                    }
                    else if(!one && !two && three && four){
                        PlainText x = new EmphasizedDecorator(new MarkDecorator(new Text(s)));
                        x.write();
                        System.out.println("");
                    }
                }
                else if(parts.size() == 3) {
                    if(one && two && three && !four){
                        PlainText x = new ParagraphDecorator(new StrongDecorator(new EmphasizedDecorator(new Text(s))));
                        x.write();
                        System.out.println("");
                    }
                    else if(one && two && !three && four){
                        PlainText x = new ParagraphDecorator(new StrongDecorator(new MarkDecorator(new Text(s))));
                        x.write();
                        System.out.println("");
                    }
                    else if(one && !two && three && four){
                        PlainText x = new ParagraphDecorator(new EmphasizedDecorator(new MarkDecorator(new Text(s))));
                        x.write();
                        System.out.println("");
                    }
                    else if(!one && two && three && four){
                        PlainText x = new StrongDecorator(new EmphasizedDecorator(new MarkDecorator(new Text(s))));
                        x.write();
                        System.out.println("");
                    }
                }
            }
        }
    }

    static String getText(){
        Scanner scan = new Scanner(System.in);
        System.out.print("ENTER YOUR TEXT: ");
        return scan.nextLine();
    }

    static ArrayList<Integer> choseTags(){
        Scanner scan = new Scanner(System.in);
        ArrayList<Integer> parts = new ArrayList<>();
        int i,j;

        showMenu();

        for(i=0,j=0; i!=5;){
            System.out.print("      Your choice: ");
            try{
                i = scan.nextInt();
                if((i >= 1) && (i <= 4)){
                    if(ifSelected(i,parts)){
                        System.out.println("         You've selected this option already.");
                        continue;
                    }
                    else{
                        parts.add(i);
                        if(ifAllSelected(parts))    { return parts; }
                        System.out.print("      Next tag? \"1\"-Yes or \"0\"-No: ");

                        j = scan.nextInt();

                        if(j == 1)
                            continue;
                        else if(j == 0)
                            return parts;
                        else
                            System.out.print("         Select \"1\"-Yes or \"0\"-No!\n");
                    }
                }
                else if(i == 5) { return parts; }
                else{
                    System.out.print("         Select correct number!\n");
                }
            }
            catch(InputMismatchException e){ System.out.print("         Select correct number! Run program again.\n"); i=5; }
        }

        return parts;
    }

    static boolean ifSelected(int which, ArrayList<Integer> al){
        for(int x : al)
            if(x == which)
                return true;
        return false;
    }

    static boolean ifAllSelected(ArrayList<Integer> al){
        boolean one = false, two = false, three = false, four = false;
        for(int x : al) {
            if (x == 1) one = true;
            if (x == 2) two = true;
            if (x == 3) three = true;
            if (x == 4) four = true;
        }
        if(one && two && three && four)
            return true;
        return false;
    }

    static void showMenu(){
        System.out.print("SELECT OPTION: \n");
        System.out.println("   1. <p>");
        System.out.println("   2. <strong>");
        System.out.println("   3. <em>");
        System.out.println("   4. <mark>");
        System.out.println("   5. Exit program\n");
    }
}
