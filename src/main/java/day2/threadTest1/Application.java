package day2.threadTest1;

public class Application {
    public static void main(String[] args) {

        System.out.println("시작");
        Test1 test1 = new Test1();
        Test2 test2 = new Test2();
        test1.printNumber();
        test2.printNumber();
        System.out.println("끝");
    }
}
