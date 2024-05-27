package day2.threadTest4;

public class ThreadEx2 extends Thread {
    public void run() {
        for (int i = 0; i < 300; i++) {
            System.out.print("|");
            for (int x = 0; x < 10000000; x++)
                ;
        }
    }
}
