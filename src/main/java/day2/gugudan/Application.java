package day2.gugudan;

public class Application {

    public static void main(String[] args) {
        NumberUtils numberUtils = new NumberUtils();
        Thread thread = new Thread(numberUtils);
        Thread thread2 = new Thread(numberUtils);
        thread.start();
        thread2.start();
    }
}
