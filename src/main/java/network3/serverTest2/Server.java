package network3.serverTest2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket;
        Socket socket;
        BufferedReader br;
        BufferedWriter bw;

        try {
            serverSocket = new ServerSocket(5678);
            System.out.println("서버가 준비되었습니다.");

            while (true) {
                try {
                    socket = serverSocket.accept();
                    br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                    bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

                    String msg = br.readLine();
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