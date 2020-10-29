package decorators;

public class StrongDecorator extends TextDecorator{
    public StrongDecorator(PlainText plainText) {
        super(plainText);
    }
    public void write(){
        System.out.print("<strong>");
        super.write();
        System.out.print("</strong>");
    }
}
