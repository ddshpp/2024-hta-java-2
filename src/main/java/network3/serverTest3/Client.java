package network3.serverTest3;

import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        try {
            String serverIp = "localhost";
            Socket socket = new Socket(serverIp, 8888);

            System.out.println("서버에 연결됨.");
            Sender sender = new Sender(socket);
            Receiver receiver = new Receiver(socket);

            sender.start();
            receiver.start();

        } catch (Exception e) {
            e.getStackTrace();
        }
    }
}
