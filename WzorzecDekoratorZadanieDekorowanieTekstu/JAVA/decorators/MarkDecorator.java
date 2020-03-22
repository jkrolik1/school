package decorators;

public class MarkDecorator extends TextDecorator{
    public MarkDecorator(PlainText plainText) {
        super(plainText);
    }
    public void write(){
        super.write();
        System.out.print("<mark>");
        super.write();
        System.out.print("</mark>");
    }
}
