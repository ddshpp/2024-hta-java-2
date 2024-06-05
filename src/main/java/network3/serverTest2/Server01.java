package network3.serverTest2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;

public class Server01 {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = null;
        Socket socket = null;

        BufferedReader br = null;
        BufferedWriter bw = null;

        try {
            serverSocket = new ServerSocket(6789);
            System.out.println("서버가 준비되었습니다.");

            while (true) {
                try {
                    socket = serverSocket.accept();

                    br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                    bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

                    String msg = br.readLine();
                    System.out.println("클라 : " + msg);
                    int number = Integer.parseInt(msg);
                    System.out.println("입력받은 단 : " + number);

                    List<String> result = Gugudan.printGugudan(number);
                    bw.write(result.toString());
                    bw.flush();

                    System.out.println("전송 완료");
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                socket.close();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
