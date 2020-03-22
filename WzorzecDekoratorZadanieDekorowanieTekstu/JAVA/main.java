import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        text1();
    }
    static void text1(){
        String s = getText();

        PlainText text = new Text(s);
        text.write();
        System.out.println("");

        PlainText addP = new ParagraphDecorator(new Text(s));
        addP.write();
        System.out.println("");

        PlainText addS = new StrongDecorator(new Text(s));
        addS.write();
        System.out.println("");

        PlainText addSandP = new ParagraphDecorator(new StrongDecorator(new Text(s)));
        addSandP.write();
        System.out.println("");
    }
    static String getText(){
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter Your text: ");
        return scan.nextLine();
    }
}
