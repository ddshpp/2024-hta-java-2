package thread1.threadTest5;

public class Application {
    public static void main(String[] args) {

        Test1 test1 = new Test1();
        Thread thread1 = new Thread(test1);
        thread1.setDaemon(true);
        thread1.start();

        for (int i = 1; i <= 10; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(i);

            if (i == 5) {
                Test1.autoSave = true;
            }
        }
    }
}
