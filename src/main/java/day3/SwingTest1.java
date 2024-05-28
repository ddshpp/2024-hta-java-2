package day3;

import java.awt.event.ComponentAdapter;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class SwingTest1 extends JFrame {

    private JPanel jPanel1 = new JPanel();
    private JButton button1 = new JButton();
    private JButton button2 = new JButton();
    private JLabel Label1;

    public SwingTest1() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("SwingTest");
        setBounds(100, 100, 500, 500);
        setLocationRelativeTo(null);
//        jPanel1.setBackground(Color.BLUE);
        jPanel1.setLayout(null);

        button1.setBounds(10, 10, 100, 30);
        button1.setText("Button1");
        jPanel1.add(button1);
        button2.setBounds(10, 50, 100, 30);
        button2.setText("Button2");
        jPanel1.add(button2);

        setContentPane(jPanel1);
        jPanel1.addComponentListener(new ComponentAdapter() {
        });
    }
}
