package network3.serverTest2;

import java.util.ArrayList;
import java.util.List;

public class Gugudan {

    public static List<String> printGugudan(int number) {
        List<String> result = new ArrayList<>();
        for (int i = 1; i <= 9; i++) {
            result.add(number + " X " + i + " = " + (number * i));
        }

        return result;
    }
}
