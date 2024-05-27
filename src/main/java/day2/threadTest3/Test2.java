package day2.threadTest3;

public class Test2 implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("우히히 : " + i);
        }
    }
}
