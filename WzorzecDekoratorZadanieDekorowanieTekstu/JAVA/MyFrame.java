import javax.swing.*;
import java.awt.*;

public class MyFrame extends JFrame{
    public MyFrame(){
        super("Decorator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700,400);
        setLocation(350,200);
        setLayout(new FlowLayout());

        add(new JButton("Confirm"));

        setVisible(true);
    }
}
