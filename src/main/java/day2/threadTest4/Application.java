package day2.threadTest4;

public class Application {
    public static void main(String[] args) {

        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                System.out.println("ㅇㅇ");
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 1000; i++) {
                    System.out.println("우히히히 : " + i);
                }
            }
        });

        thread1.start();
        thread2.start();
    }
}
