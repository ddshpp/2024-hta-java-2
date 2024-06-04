package thread.threadTest8;

public class Test1 extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 300; i++) {
            System.out.println("-");
        }
    }
}
