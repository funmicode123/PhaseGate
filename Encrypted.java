import java.util.Scanner;
public class Cryptography {
	public static void main(String... args){
	Scanner input = new Scanner(System.in);
	System.out.print("Enter integer: ");
	int number = input.nextInt();
	
	int getEncryptedResult = getEncrypted(number);
	System.out.printf("Encrypted: %04d\n", getEncryptedResult);

	int getDecryptedResult = getDecrypted(number);
	System.out.printf("Decrypted: %04d\n", getDecryptedResult);


	}

public static int getEncrypted(int number){
int digit1 = number % 10;
number = number / 10;
int digit2 = number % 10;
number = number / 10;
int digit3 = number % 10;
number = number / 10;
int digit4 = number % 10;
number = number / 10;


int alpha1 = (digit4 + 7) % 10;
int alpha2 = (digit3 + 7) % 10;
int alpha3 = (digit2 + 7) % 10;
int alpha4 = (digit1 + 7) % 10;

int encrypted = (alpha3 * 1000) + (alpha4 * 100) + (alpha1 * 10) + alpha2;
return encrypted;

}

public static int getDecrypted(int number){
int digit1 = number % 10;
number = number / 10;
int digit2 = number % 10;
number = number / 10;
int digit3 = number % 10;
number = number / 10;
int digit4 = number % 10 ;
number = number / 10;


int alpha1 = (digit4 + 7) % 10;
int alpha2 = (digit3 + 7) % 10;
int alpha3 = (digit2 + 7) % 10;
int alpha4 = (digit1 + 7) % 10;

int beta1 = (alpha1 + 3) % 10;
int beta2 = (alpha2 + 3) % 10;
int beta3 = (alpha3 + 3) % 10;
int beta4 = (alpha4 + 3) % 10;

int decrypted = (beta1 * 1000) + (beta2 * 100) + (beta3 * 10) + beta4;
return decrypted;


}

}