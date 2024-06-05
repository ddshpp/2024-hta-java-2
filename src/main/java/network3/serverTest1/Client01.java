package network3.serverTest1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class Client01 {
    public static void main(String[] args) {
        Socket socket = null;
        BufferedReader br = null;
        BufferedWriter bw = null;

        try {
//            socket = new Socket("192.168.0.62", 7777);
            socket = new Socket("localhost", 6789);

            br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

            bw.write("안녕!!!!나는 클라이언트야!!!!!!!!!!" + "\n");
            bw.flush();
            System.out.println("연결완료");

            String msg = br.readLine();
            System.out.println("서버: " + msg);
        } catch (IOException e) {
            System.out.println("[에러] : " + e.getMessage());
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                }
            }
            if (bw != null) {
                try {
                    bw.close();
                } catch (IOException e) {
                }
            }
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                }
            }
        }
    }
}
