package day2.swingTest;

import javax.swing.JFrame;

public class Test2 extends JFrame {
    public static void main(String[] args) {
        Test2 frame = new Test2();
        frame.setVisible(true);
    }

    public Test2() {
        setTitle("Test2");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        setLocationRelativeTo(null);
    }
}
