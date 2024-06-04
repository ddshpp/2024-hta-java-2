package thread.synchronizedTest;

public class Account {
    int balance = 1000;

    public synchronized void withdraw(int amount) {
        if (balance >= amount) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            balance -= amount;
        }
    }

    public int getBalance() {
        return balance;
    }
}
