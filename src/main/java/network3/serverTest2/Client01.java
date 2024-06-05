package network3.serverTest2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client01 {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        Socket socket = null;
        BufferedReader br = null;
        BufferedWriter bw = null;

        try {
            String sendMessage = scanner.nextLine();

            while (sendMessage != null) {
                socket = new Socket("localhost", 6789);
                br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

                bw.write(sendMessage + "\n");
                bw.flush();
                System.out.println("전송완료");

                String returnMessage = br.readLine();
                PrintUtils.printResult(returnMessage);

                sendMessage = scanner.nextLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
