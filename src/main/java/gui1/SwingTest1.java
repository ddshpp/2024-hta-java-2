package gui1;

import java.awt.event.ComponentAdapter;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SwingTest1 extends JFrame {

    private JPanel jPanel1 = new JPanel();
    private JButton button1 = new JButton();
    private JButton button2 = new JButton();
    private final JLabel jLabel1 = new JLabel();
    private JTextField textField1 = new JTextField();
    private JLabel jLabel;

    public SwingTest1() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("SwingTest");
        setBounds(100, 100, 500, 500);
        setLocationRelativeTo(null);
        jPanel1.setLayout(null);

        button1.setBounds(10, 10, 100, 30);
        button1.setText("Button1");
        jPanel1.add(button1);
        button2.setBounds(10, 50, 100, 30);
        button2.setText("Button2");
        jPanel1.add(button2);

        jLabel1.setText("Label1");
        jLabel1.setBounds(10, 100, 100, 30);
        jPanel1.add(jLabel1);

        textField1.setBounds(100, 100, 150, 30);
        jPanel1.add(textField1);

        setContentPane(jPanel1);
        jPanel1.addComponentListener(new ComponentAdapter() {
        });
    }
}
