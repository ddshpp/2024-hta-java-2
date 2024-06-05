package network3.serverTest2;

public class PrintUtils {

    public static void printResult(String returnMessage) {
        String substring = getSubstring(returnMessage);
        String[] result = substring.split(",");
        for (String str : result) {
            System.out.println(str.trim());
        }
    }

    private static String getSubstring(String returnMessage) {
        return returnMessage.substring(1, returnMessage.length() - 1);
    }
}
