public class ReversedString{

	public static void main(String... args){
		String example = "There is a tide in the affairs of men";

		String[] arrayString = example.split(" ");


		System.out.println("Reversed sentence is: " + reverseString(arrayString));
	}


	public static String reverseString(String[] arrayString){
		
		String reverseString = "";

		for(int index =0; index < arrayString.length; index++){
			reverseString = arrayString[index] + " " + reverseString;
		

		}
		return reverseString;

	}															

}