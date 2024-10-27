
public class Product{
	public static void main(String[] args){
	int number1 = 3;
	int number2 = 5;

	
	int result = findProduct(number1, number2);
	System.out.println("Result: "+ result);
	}


	public static int findProduct(int number1, int number2){
		int product =0;
		if(number1 ==0 || number2 ==0){
			return 0;
		}

		if(number1 < 0 && number2 < 0){
			number1 = -number1;
			number2 = -number2;
		}

		else if (number1 < 0 ){
			return -findProduct(-number1, number2);
		}
		else if (number2 < 0 ){
			return -findProduct(number1, -number2);
		}


		for(int index =0; index < number1; index++){
			product += number2;

		}
		return product;

		
	}


}