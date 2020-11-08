package decorators;

public class ParagraphDecorator extends TextDecorator{
    public ParagraphDecorator(PlainText plainText) {
        super(plainText);
    }
    public void write(){
        System.out.print("<p>");
        super.write();
        System.out.print("</p>");
    }
}
