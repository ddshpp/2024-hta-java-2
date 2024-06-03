package thread1.threadTest5;

public class Test1 implements Runnable {

    public static boolean autoSave = false;

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(3 * 1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            if (autoSave) {
                autoSave();
            }
        }
    }

    public void autoSave() {
        System.out.println("자동저장됨");
    }
}
