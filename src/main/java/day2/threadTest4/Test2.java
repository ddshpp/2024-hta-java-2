package day2.threadTest4;

public class Test2 {
    public static void main(String[] args) {
        ThreadEx1 thread1 = new ThreadEx1();
        ThreadEx2 thread2 = new ThreadEx2();
        thread2.setPriority(7);

        System.out.println("priority of thread1(-) :" + thread1.getPriority());
        System.out.println("priority of thread2(|) :" + thread2.getPriority());

        thread1.start();
        thread2.start();
    }
}
