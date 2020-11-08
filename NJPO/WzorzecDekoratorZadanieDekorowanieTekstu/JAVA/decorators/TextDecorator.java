package decorators;

public abstract class TextDecorator extends PlainText {
    protected PlainText plainText;
    public TextDecorator(PlainText plainText)  { this.plainText = plainText; }
    @Override
    public void write(){
        plainText.write();
    }
}
