import java.util.Scanner;

public class BankeBankTest {
    public static void main(String[] args) {
        BankeBank account1 = new BankeBank("Funmilola Sanni", "1127465788", 0.0, "1244");
        BankeBank account2 = new BankeBank("Oluwaseun Ajayi", "4592209763", 0.0, "5678");

        System.out.printf("%s balance: #%.2f%n", account1.getName(), account1.getBalance());
        System.out.printf("%s balance: #%.2f%n", account2.getName(), account2.getBalance());

        Scanner input = new Scanner(System.in);

        System.out.print("Enter deposit amount for account1: ");
        double depositAmount1 = input.nextDouble();
        account1.deposit(depositAmount1);

        System.out.print("Enter deposit amount for account2: ");
        double depositAmount2 = input.nextDouble();
        account2.deposit(depositAmount2);

        System.out.printf("%s balance: #%.2f%n", account1.getName(), account1.getBalance());
        System.out.printf("%s balance: #%.2f%n", account2.getName(), account2.getBalance());


        account1.transfer(account2, 500.0);
        System.out.printf("After transfer, %s balance: #%.2f%n", account1.getName(), account1.getBalance());
        System.out.printf("After transfer, %s balance: #%.2f%n", account2.getName(), account2.getBalance());


        account1.withdraw(200.0, "1244");
	System.out.printf("After withdraw, %s balance: #%.2f%n", account1.getName(), account1.getBalance());
	
	System.out.printf("%s Pin: %s%n", account1.getName(), account1.changePin("1244", "1244"));
	System.out.printf("%s Pin: %s%n", account2.getName(), account2.changePin("5678", "8834"));


        account2.closeAccount();
        System.out.printf("%s balance after closing: #%.2f%n", account2.getName(), account2.getBalance());


    }
}
