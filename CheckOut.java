import java.util.Scanner;
import java.util.ArrayList;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class CheckOut {

    public static void main(String... args) {
        Scanner input = new Scanner(System.in);
        System.out.print("What is the customer's name? ");
        String customerName = input.nextLine().trim();

	LocalDateTime currentDateTime = LocalDateTime.now();

	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
	String formattedDateTime = currentDateTime.format(formatter);

	ArrayList<String> items = new Arraylist<>();
	ArrayList<Integer> prices = new Arraylist<>();
	ArrayList<Integer> quantities = new Arraylist<>();

        askForItems(input); 
    }

    public static void askForItems(Scanner input, ArrayList<String> items, ArrayList<Integer> prices, ArrayList<Integer> quantities) {
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

            System.out.print("Add more items? (yes or no) ");
            String addMore = input.nextLine().trim();

            if (addMore.equalsIgnoreCase("yes")) {
                continue;  

            } 
		else if (addMore.equalsIgnoreCase("no")) {
                    System.out.println("What is the cashier's name?");
		    String cashierName = input.nextLine().trim();
		    input.nextLine();

		    System.out.println("How much discount will he got");  
		    int discount = input.nextInt();
                } 
	    else {
                System.out.println("Invalid input, kindly check and try again.");
            }
        }

        System.out.printf("SEMICOLON STORES\n MAIN BRANCH\n LOCATION: 312, HERBERT MACAULAY WAY, SABO YABA, LAGOS\n TEL: 03293828343");
	System.out.println("Date: ", formattedDateTime);
	System.out.println("Cahier's name: ", cashierName);
	System.out.println("Customer's name", customerName);

	System.out.println("=================================================");
	System.out.println(\t\t"ITEM"\t"QTY"\t"Price"\t"TOTAL(NGN)");
	System.out.println("---------------------------------------------------");
	

    }

}
