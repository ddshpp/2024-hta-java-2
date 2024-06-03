package thread1.threadTest6;

public class Application {
    public static void main(String[] args) {
        Test1 test1 = new Test1();
        Test2 test2 = new Test2();
        Thread thread1 = new Thread(test1);
        Thread thread2 = new Thread(test2);

        thread1.start();
        thread2.start();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("main 종료");
    }
}
