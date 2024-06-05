package network3.serverTest1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server01 {
    public static void main(String[] args) {

        ServerSocket serverSocket = null;
        Socket socket = null;

        BufferedReader br = null;
        BufferedWriter bw = null;

        try {
            serverSocket = new ServerSocket(6789);
//            serverSocket = new ServerSocket(7777);

            //항시 대기 서버
            while (true) {
                try {
                    System.out.println("서버가 준비되었습니다.");
                    socket = serverSocket.accept();

                    br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                    bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

                    String msg = br.readLine();
                    System.out.println("msg : " + msg);

                    bw.write(msg + "\n");
                    bw.flush();
                    System.out.println("전송 완료");

                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                } finally {
                    if (socket != null) {
                        try {
                            socket.close();
                        } catch (IOException e) {
                            throw new RuntimeException("error close socket", e);
                        }
                    }
                }
            }

        } catch (IOException e) {
            System.out.println("[에러] : " + e.getMessage());
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    throw new RuntimeException("error close stream", e);
                }
            }
            if (bw != null) {
                try {
                    bw.close();
                } catch (IOException e) {
                    throw new RuntimeException("error close stream", e);
                }
            }
            if (serverSocket != null) {
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    throw new RuntimeException("error close server socket", e);
                }
            }
        }
    }
}
