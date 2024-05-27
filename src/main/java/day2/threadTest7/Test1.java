package day2.threadTest7;

public class Test1 extends Thread {

    @Override
    public void run() {
        int i = 10;

        while (i != 0 && !isInterrupted()) {
            System.out.println(i--);
            for (long x = 0; x < 2500000000L; x++)
                ;
        }

        System.out.println("카운트 종료");
    }
}
