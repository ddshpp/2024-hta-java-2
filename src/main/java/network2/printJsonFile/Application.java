package network2.printJsonFile;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Application {
    public static void main(String[] args) throws Exception {
        printJson1();
        printJson2();
    }

    private static void printJson2() throws IOException, ParseException {
        JSONParser parser = new JSONParser();
        Reader reader = new FileReader("src/main/java/json/JsonTest.json");
        JSONObject jsonObject = (JSONObject) parser.parse(reader);

        String name = (String) jsonObject.get("name");
        long id = (Long) jsonObject.get("id");
        System.out.println(name);
        System.out.println(id);
    }

    private static void printJson1() {
        String strJson = "{"
                + "\"data1\" : [1, 2, 3, 4], "
                + "\"data2\" : [\"100\", \"200\", \"300\", \"400\"]"
                + "}";
        JSONParser parser = new JSONParser();

        try {
            JSONObject obj = (JSONObject) parser.parse(strJson);
            JSONArray arr1 = (JSONArray) obj.get("data1");
            System.out.println(arr1);

            JSONArray arr2 = (JSONArray) obj.get("data2");
            System.out.println(arr2);
        } catch (ParseException e) {
            throw new RuntimeException("Error parsing JSON", e);
        }
    }
}
