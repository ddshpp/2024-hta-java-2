package network3.serverTest1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server01 {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        ServerSocket serverSocket = null;
        Socket socket = null;

        BufferedReader br = null;
        BufferedWriter bw = null;

        try {
            serverSocket = new ServerSocket(6789);
//            serverSocket = new ServerSocket(7777);

            String sendMessage = scanner.nextLine();
            System.out.println("서버가 준비되었습니다.");

            //항시 대기 서버
            while (sendMessage != null) {
                try {
                    socket = serverSocket.accept();

                    br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                    bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

                    bw.write(sendMessage + "\n");
                    bw.flush();
                    System.out.println("전송 완료");

                    String msg = br.readLine();
                    System.out.println("클라 : " + msg);

                    sendMessage = scanner.nextLine();

                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                socket.close();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        if (br != null) {
            br.close();
        }
        if (bw != null) {
            bw.close();
        }
        serverSocket.close();
    }
}
