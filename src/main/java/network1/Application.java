package network1;

import java.io.IOException;
import java.net.URL;

public class Application {
    public static void main(String[] args) throws Exception {

        getInfo();
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
