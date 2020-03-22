import java.awt.*;

public class Window {
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable(){
            @Override
            public void run(){
                new MyFrame();
            }
        });
    }
}
