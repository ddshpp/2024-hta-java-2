package day2.gugudan;

import java.util.Scanner;

public class NumberUtils implements Runnable {

    @Override
    public void run() {
        System.out.println("숫자를 입력하세요");
        Scanner scanner = new Scanner(System.in);
        int inputNumber = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i < 10; i++) {
            System.out.println(inputNumber + " X " + i + " = " + inputNumber * i);
        }
    }
}
