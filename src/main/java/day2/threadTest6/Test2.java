package day2.threadTest6;

public class Test2 implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 300; i++) {
            System.out.print("|");
        }
        System.out.println();
        System.out.println("thread2 종료");
    }
}
