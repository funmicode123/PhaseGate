import java.util.Scanner;
import java.util.ArrayList;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CheckOut {
    private static final double VAT = 17.50;  

    public static void main(String... args) {
        Scanner input = new Scanner(System.in);
        System.out.print("What is the customer's name? ");
        String customerName = input.nextLine().trim();

        LocalDateTime currentDateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedDateTime = currentDateTime.format(formatter);

        ArrayList<String> items = new ArrayList<>();
        ArrayList<Integer> prices = new ArrayList<>();
        ArrayList<Integer> quantities = new ArrayList<>();

        double totalCost = askForItems(input, items, prices, quantities);
        System.out.print("What is the cashier's name? ");
        String cashierName = input.nextLine().trim();

        System.out.print("How much discount will the customer receive? ");
        double discount = input.nextDouble();

        double vatAmount = (VAT * totalCost) / 100;
        double totalBill = totalCost + vatAmount - discount;

        printReceipt(customerName, cashierName, formattedDateTime, items, prices, quantities, totalCost, totalBill, vatAmount, discount);
        displayReceipt(input, customerName, cashierName, formattedDateTime, items, prices, quantities, totalCost, totalBill, vatAmount, discount);
    }

    public static double askForItems(Scanner input, ArrayList<String> items, ArrayList<Integer> prices, ArrayList<Integer> quantities) {
        double totalCost = 0;

        while (true) {
            System.out.print("What did the user buy? ");
            String item = input.nextLine().trim();
            items.add(item);

            System.out.print("How many pieces? ");
            int quantity = input.nextInt();
            quantities.add(quantity);
            input.nextLine();

            System.out.print("How much per unit? ");
            int price = input.nextInt();
            prices.add(price);
            input.nextLine();

            totalCost += price * quantity;

            System.out.print("Add more items? (yes or no) ");
            String addMore = input.nextLine().trim();

            if (addMore.equalsIgnoreCase("yes")) {
                continue;  
            } 
	        else if (addMore.equalsIgnoreCase("no")) {
                    break;  
            } 
	    else {
                System.out.println("Invalid input, kindly check and try again.");
            }
        }
        return totalCost;
    }

    public static void printReceipt(String customerName, String cashierName, String formattedDateTime, ArrayList<String> items, ArrayList<Integer> prices, ArrayList<Integer> quantities, double totalCost, double totalBill, double vatAmount, double discount) {

        System.out.println("\nSEMICOLON STORES");
        System.out.println("MAIN BRANCH\nLOCATION: 312, HERBERT MACAULAY WAY, SABO YABA, LAGOS\nTEL: 03293828343");
        System.out.println("Date: " + formattedDateTime);
        System.out.println("Cashier's Name: " + cashierName);
        System.out.println("Customer's Name: " + customerName);
        System.out.println("================================================================");
        System.out.printf("\t\t%-10s%-10s%-10s%-10s%n", "ITEM", "QTY", "PRICE", "TOTAL(NGN)");
        System.out.println("----------------------------------------------------------------");

        for (int index = 0; index < items.size(); index++) {
            int itemTotal = prices.get(index) * quantities.get(index);
            System.out.printf("\t\t%-10s%-10d%-10.2f%-10.2f%n", items.get(index), quantities.get(index), (double) prices.get(index), (double) itemTotal);
        }

        System.out.println("----------------------------------------------------------------");
        System.out.printf("\t\t\tSub Total: %23.2f%n", totalCost);
        System.out.printf("\t\t\tDiscount: %24.2f%n", discount);
        System.out.printf("\t\t\tVAT (%.2f%%): %20.2f%n", VAT, vatAmount);
        System.out.println("================================================================");
        System.out.printf("\t\t\tBill Total: %24.2f%n", totalBill);
        System.out.println("================================================================");
        System.out.println("THIS IS NOT A RECEIPT, PLEASE PAY " + totalBill + " AT THE FRONT DESK.");
        System.out.println("================================================================");
    }

    public static void displayReceipt(Scanner input, String customerName, String cashierName, String formattedDateTime, ArrayList<String> items, ArrayList<Integer> prices, ArrayList<Integer> quantities, double totalCost, double totalBill, double vatAmount, double discount) {
        System.out.print("How much did the customer give? ");
        double amountPaid = input.nextDouble();
        double balance = amountPaid - totalBill;

        System.out.println("\nSEMICOLON STORES");
        System.out.println("MAIN BRANCH\nLOCATION: 312, HERBERT MACAULAY WAY, SABO YABA, LAGOS\nTEL: 03293828343");
        System.out.println("Date: " + formattedDateTime);
        System.out.println("Cashier's Name: " + cashierName);
        System.out.println("Customer's Name: " + customerName);
        System.out.println("================================================================");
        System.out.printf("\t\t%-10s%-10s%-10s%-10s%n", "ITEM", "QTY", "PRICE", "TOTAL(NGN)");
        System.out.println("----------------------------------------------------------------");

        for (int index = 0; index < items.size(); index++) {
            int itemTotal = prices.get(index) * quantities.get(index);
            System.out.printf("\t\t%-10s%-10d%-10.2f%-10.2f%n", items.get(index), quantities.get(index), (double) prices.get(index), (double) itemTotal);
        }

        System.out.println("----------------------------------------------------------------");
        System.out.printf("\t\t\tSub Total: %23.2f%n", totalCost);
        System.out.printf("\t\t\tDiscount: %24.2f%n", discount);
        System.out.printf("\t\t\tVAT (%.2f%%): %20.2f%n", VAT, vatAmount);
        System.out.println("================================================================");
        System.out.printf("\t\t\tBill Total: %24.2f%n", totalBill);
        System.out.printf("\t\t\tAmount Paid: %23.2f%n", amountPaid);
        System.out.printf("\t\t\tBalance: %27.2f%n", balance);
        System.out.println("================================================================");
        System.out.println("\t\tTHANK YOU FOR YOUR PATRONAGE");
        System.out.println("================================================================");
    }
}
