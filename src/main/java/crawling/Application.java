package crawling;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

public class Application {
    public static void main(String[] args) throws Exception {

//        getInfo();
//        printHTML1();
//        printHTML2();
//        printHTML3();


    }

    private static void printHTML3() throws IOException {
        URL url = new URL("https://news.daum.net/");

        InputStreamReader inputStreamReader = new InputStreamReader(url.openStream());
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        String inputLine;
        boolean flag = false;

        while ((inputLine = bufferedReader.readLine()) != null) {
            if(inputLine.contains(" class=\"link_txt\" data-tiara-layer=\"article_main\"")) {
                flag = true;
            }
            if(inputLine.contains("</a>")) {
                flag = false;
            }
            if(flag) {
                System.out.println(bufferedReader.readLine().trim());
            }
        }
    }

    private static void printHTML2() throws IOException {
        URL url = new URL("https://www.naver.com/");

        InputStreamReader inputStreamReader = new InputStreamReader(url.openStream());
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        String inputLine;
        while ((inputLine = bufferedReader.readLine()) != null) {
            System.out.println(inputLine);
        }
    }

    private static void printHTML1() throws IOException {
        URL url = new URL("https://www.naver.com/");
        InputStream inputStream = url.openStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

        String line;
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }
    }

    private static void getInfo() throws IOException {
        URL url = new URL("https://sports.news.naver.com/wfootball/record/index.html");

        String result = "url.getAuthority()" + url.getAuthority() + System.lineSeparator() +
                "url.getContent()" + url.getContent() + System.lineSeparator() +
                "url.getDefaultPort()" + url.getDefaultPort() + System.lineSeparator() +
                "url.getPort()" + url.getPort() + System.lineSeparator() +
                "url.getFile()" + url.getFile() + System.lineSeparator() +
                "url.getHost()" + url.getHost() + System.lineSeparator();
        System.out.println(result);
    }
}
