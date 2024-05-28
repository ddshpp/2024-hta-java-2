package day3;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class SwingTest1 extends JFrame {

    private JPanel jPanel1 = new JPanel();
    private JButton button1 = new JButton("Button1");
    private JButton button2 = new JButton("Button2");
    private JButton button3 = new JButton("Button3");
    private JLabel Label1;
    private JLabel Label2;

    public SwingTest1() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("SwingTest");
        setBounds(100, 100, 500, 500);
        setLocationRelativeTo(null);
        jPanel1.setBackground(Color.BLUE);
        jPanel1.setLayout(null);

        button1.setBounds(10, 10, 100, 30);
        jPanel1.add(button1);
        button2.setBounds(10, 50, 100, 30);
        jPanel1.add(button2);
        button3.setBounds(10, 90, 100, 30);
        jPanel1.add(button3);

        setContentPane(jPanel1);
    }
}
