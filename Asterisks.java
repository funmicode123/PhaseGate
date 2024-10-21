public class Asterisks {
	public static void main(String... args){
	 String input = " * ";

		for( int counter = 1; counter <= 6; counter++){
			for(int inner = 0; inner < counter; inner++){
			System.out.print(input);
			System.out.print("");

			}

			System.out.println();

		}

			System.out.println();


		for(int counter = 6; counter > 0; counter--){

			for(int inner = 0; inner <= counter - 1; inner++) {
				System.out.print(input);
				

			}

				System.out.println();

		}

		for(int counter = 6; counter >= 1; counter--){
			for(int space = 0; space < 6 - counter; space++){
				System.out.print("  ");
			}

			for(int inner = 1; inner <= counter; inner++){

				System.out.print("* ");

			}

				System.out.println();

		}
			System.out.println();

		for(int counter = 6; counter >= 1; counter--){
			for(int space = 0; space < counter-1; space++){
				System.out.print("  ");

			}

			for(int inner = 1; inner <=6- counter + 1; inner++){
			System.out.print("* ");

			}
			
			System.out.println();

		}

	}
