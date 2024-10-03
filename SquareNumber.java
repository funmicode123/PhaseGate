import java.util.Arrays;
public class SquareNumber{

	public static void main(String[] args){

		int[] numbers = {2, 1, 4, 3, 5, 9};

		int[] numbersSquared = squareInteger(numbers);

		
		Arrays.sort(numbersSquared);
		

		System.out.println("Squared numbers in ascending order: " + Arrays.toString(numbersSquared));
		
	
	}
	public static int[] squareInteger (int[] numbers){
        	int[] squaredNumbers = new int[numbers.length];

        	for (int index = 0; index < numbers.length; index++) {
        	    squaredNumbers[index] = numbers[index] * numbers[index];

       		}
       		return squaredNumbers;



	}

	





}


