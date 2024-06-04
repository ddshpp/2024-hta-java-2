package thread.synchronizedTest;

public class Application {
    public static void main(String[] args) {
        Account account = new Account();

        Client client1 = new Client(account);
        Client client2 = new Client(account);

        Thread thread1 = new Thread(client1);
        Thread thread2 = new Thread(client2);

        thread1.start();
        thread2.start();
    }
}
