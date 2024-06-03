package thread1.threadTest8;

public class Application {
    static long startTime = 0;

    public static void main(String[] args) {
        Test1 test1 = new Test1();
        Test2 test2 = new Test2();

        test1.start();
        test2.start();

        startTime = System.currentTimeMillis();

        try {
            test1.join();
            test2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("소요시간" + (System.currentTimeMillis() - startTime) + "ms");
    }
}
