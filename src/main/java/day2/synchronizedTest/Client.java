package day2.synchronizedTest;

public class Client implements Runnable {
    private Account account;

    public Client(Account account) {
        this.account = account;
    }

    @Override
    public void run() {
        while (account.getBalance() > 0) {
            int money = (int) (Math.random() * 3 + 1) * 100;
            account.withdraw(money);
            System.out.println("Account balance: " + account.getBalance());
        }
    }
}
