public class SquareNumber2 {

    public static void main(String[] args) {
        int[] numbers = {2, 1, 4, 3, 5, 9};

        int[] sortedSquares = sortSquaredNumbers(numbers);
	
	System.out.print("Squared numbers in ascending order: [");
        for (int index = 0; index < sortedSquares.length; index++) {
            System.out.printf("%d%s ", sortedSquares[index], (index < sortedSquares.length - 1) ? "," : "]");
        }

    }


    public static int[] sortSquaredNumbers(int[] numbers) {
        int[] squaredNumbers = new int[numbers.length];

        for (int index = 0; index < numbers.length; index++) {
            squaredNumbers[index] = numbers[index] * numbers[index];
        }

        boolean swapped;
        for (int count = 0; count < squaredNumbers.length - 1; count++) {
            swapped = false;
            for (int index = 0; index < squaredNumbers.length - count - 1; index++) {
                if (squaredNumbers[index] > squaredNumbers[index + 1]) {
                    int compare = squaredNumbers[index];
                    squaredNumbers[index] = squaredNumbers[index + 1];
                    squaredNumbers[index + 1] = compare;
                    swapped = true;
                }
            }
            if (!swapped) break;
        }

        return squaredNumbers;
    }
}
