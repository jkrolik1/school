public class EmphasizedDecorator extends TextDecorator{
    public EmphasizedDecorator(PlainText plainText) {
        super(plainText);
    }
    public void write(){
        super.write();
        System.out.print("</em>");
    }
}
