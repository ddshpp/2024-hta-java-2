package day2.gugudan;

public class Application {

    public static void main(String[] args) {
        NumberUtils numberUtils = new NumberUtils();
        Thread thread = new Thread(numberUtils);
        Thread thread2 = new Thread(numberUtils);

        thread.start();
        thread2.start();

        sleepTest();
    }

    private static void sleepTest() {
        try {
            Thread.sleep(3 * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
