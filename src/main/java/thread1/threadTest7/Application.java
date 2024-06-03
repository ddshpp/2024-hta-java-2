package thread1.threadTest7;

import javax.swing.JOptionPane;

public class Application {
    public static void main(String[] args) {
        Test1 test1 = new Test1();
        test1.start();

        String input = JOptionPane.showInputDialog("숫자입력해봐라");
        System.out.println("입력값 :" + input);

        test1.interrupt();
        System.out.println("test1.isInterrupted() : " + test1.isInterrupted());
    }
}
