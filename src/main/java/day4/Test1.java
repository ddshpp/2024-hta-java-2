package day4;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;

public class Test1 extends JFrame{
    private JPanel panel1;
    private JButton button1;
    private JButton button2;

    public Test1() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("SwingTest");
        setBounds(100, 100, 500, 500);
        setLocationRelativeTo(null);
        panel1 = new JPanel();
        panel1.setLayout(null);

        panel1.add(new JLabel("Hello World!"));
        button1 = new JButton("Button1");
        button1.setBounds(10, 10, 100, 30);
        panel1.add(button1);
        button2 = new JButton("Button2");
        button2.setBounds(10, 50, 100, 30);
        panel1.add(button2);

        setContentPane(panel1);
    }
}
