package decorators;

public class EmphasizedDecorator extends TextDecorator {
    public EmphasizedDecorator(PlainText plainText) {
        super(plainText);
    }
    public void write(){
        System.out.print("<em>");
        super.write();
        System.out.print("</em>");
    }
}
