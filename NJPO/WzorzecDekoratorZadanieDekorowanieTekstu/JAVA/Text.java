import decorators.PlainText;

class Text extends PlainText {
    protected String s;

    public Text(String s){
        setS(s);
    }

    public void setS(String userText){
        if(!(userText.isEmpty()))
            s = userText;
    }

    @Override
    public void write() {
        System.out.print(s);
    }

}
