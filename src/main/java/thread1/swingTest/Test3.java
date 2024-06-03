package thread1.swingTest;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Test3 extends JFrame {
    private final JPanel contentPane;

    public Test3() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Test3");
        setSize(300, 300);
        setLocationRelativeTo(null);

        contentPane = new JPanel();
        contentPane.setBackground(Color.BLUE);
        contentPane.setLayout(null);

        JButton button1 = new JButton("Button 1");
        button1.setBackground(Color.RED);
        button1.setBounds(10, 10, 100, 30);
        contentPane.add(button1);
        JButton button2 = new JButton("Button 2");
        button2.setBackground(Color.RED);
        button2.setBounds(10, 50, 100, 30);
        contentPane.add(button2);

        setContentPane(contentPane);
    }

    public static void main(String[] args) {
        Test3 test3 = new Test3();
        test3.setVisible(true);
    }
}
