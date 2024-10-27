public class BankeBank {
    private String name;
    private String accountNumber;
    private double balance;
    private String pin;

    public BankeBank(String name, String accountNumber, double initialBalance, String pin) {
        this.name = name;
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
        this.pin = pin;
    }


    public String getName() {
        return name;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
	if (amount < 0) {
            return;
        }
        else {
            balance += amount;
        }
    }

    public void transfer(BankeBank recepientAccount, double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            recepientAccount.deposit(amount);
        }
    }

    public void withdraw(double amount, String pin) {
        if (this.pin.equals(pin) && amount <= balance) {
            balance -= amount;
        }
    }

    public String changePin(String oldPin, String newPin) {
        if (this.pin.equals(oldPin)) {
            this.pin = newPin;
        }

	return newPin;
    }

    public void closeAccount() {
        this.balance = 0;
    }
}
