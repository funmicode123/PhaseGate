import java.util.Scanner;

public class CreditCardValidator {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Hello, kindly enter the card number to verify: ");
        String cardNumberStr = input.nextLine();

        System.out.println("Card Number: " + cardNumberStr);

        int lengthResult = getLength(cardNumberStr);
        System.out.println("Card Length: " + lengthResult);

        if (lengthResult < 13 || lengthResult > 16) {
            System.out.println("Invalid Length");
        } 
        else {
            System.out.println("Valid Length");
        }

        
        int[] cardNumbers = new int[cardNumberStr.length()];
        for (int index = 0; index < cardNumberStr.length(); index++) {
            cardNumbers[index] = Character.getNumericValue(cardNumberStr.charAt(index));
        }

        String cardType = getCreditCardType(cardNumbers);
        System.out.println("Card Type: " + cardType);

        String validity = getValidity(cardNumberStr);
        System.out.println("Card Validity Status: " + validity);


    }

    public static String getValidity(String cardNumberStr) {
        int sumLeftToRight = 0;
        int[] cardNumbers = new int[cardNumberStr.length()];
 
        for (int index = 0; index < cardNumberStr.length(); index++) {
            cardNumbers[index] = Character.getNumericValue(cardNumberStr.charAt(index));
        }

        for (int index = cardNumbers.length - 2; index >= 0; index -= 2) {
            int number = cardNumbers[index] * 2;
            if (number > 9) {
                sumLeftToRight += number / 10 + number % 10;  
            }
	    else {
                sumLeftToRight += number;
            }
        }

        for (int index = cardNumbers.length - 1; index >= 0; index -= 2) {
            sumLeftToRight += cardNumbers[index];
        }

        System.out.println("Sum of the second digit: " + sumLeftToRight);


        if (sumLeftToRight % 10 == 0) {
            return "Valid";
        } else {
            return "Invalid";
        }
    }

    public static int getLength(String cardNumberStr) {

        return cardNumberStr.length();
    }

    private static String getCreditCardType(int[] cardNumbers) {
        if (cardNumbers[0] == 4) {
            return "Visa Card";
        } else if (cardNumbers[0] == 5) {
            return "MasterCard";
        } else if (cardNumbers[0] == 6) {
            return "Discover Card";
        } else if (cardNumbers.length > 1 && cardNumbers[0] == 3 && cardNumbers[1] == 7) {
            return "American Express Card";
        } else {
            return "Invalid Card Type";
        }
    }
}
