import java.util.Scanner;

public class CreditCardValidator {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Hello, kindly enter the card number to verify: ");
        String cardNumberStr = input.nextLine();

        int[] cardNumbers = new int[cardNumberStr.length()];
        for (int index = 0; index < cardNumberStr.length(); index++) {
            cardNumbers[index] = Character.getNumericValue(cardNumberStr.charAt(index));
        }
       
        int[] sumLeftToRight = new int[];
        
        for (int index = 0; index < cardNumbers.length; index += 2) {
            if (cardNumbers[index] < 5){
                sumLeftToRight += cardNumbers[index] * 2;
            }
            else{
                int number = cardNumbers[index] * 2;
                int sumNumber = 
                sumLeftToRight += 

            }

            }
        }
        System.out.println("Sum of second digit from left to right: " + sumLeftToRight);
        System.out.println();

        String cardType = getCreditCardType(cardNumbers);
        System.out.println("Card Type: " + cardType);
    }

    private static String getCreditCardType(int[] cardNumbers) {
        if (cardNumbers[0] == 4) {
            return "Visa Card";
        }
        else if (cardNumbers[0] == 5) {
            return "MasterCard";
        }
        else if (cardNumbers[0] == 6) {
            return "Discover Card";
        }
        else if (cardNumbers.length > 1 && cardNumbers[0] == 3 && cardNumbers[1] == 7) {
            return "American Express Card";
        }
        else {
            return "Invalid Card Type";
        }
    }
}
