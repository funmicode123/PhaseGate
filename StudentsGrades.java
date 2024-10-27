import java.util.Scanner;

public class StudentsGrades {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);


        System.out.print("Enter the number of students: ");
        int numberOfStudents = input.nextInt();

        System.out.print("Enter the number of subjects: ");
        int numberOfSubjects = input.nextInt();

        System.out.print("Saving >>>>>>>>>>Saved successfully\n");
        int[][] scores = new int[numberOfStudents][numberOfSubjects];
        int[] total = new int [numberOfStudents];
	double[] average = new double[numberOfStudents];

        for (int index = 0; index < numberOfStudents; index++) {  
            System.out.println("Enter scores for Student " + (index + 1) + ":");
            for (int count = 0; count < numberOfSubjects; count++) {  
                System.out.print("  Score for Subject " + (count + 1) + ": ");
                scores[index][count] = input.nextInt(); 
 		total[index] += scores[index][count];
            }

	    average[index] = (double) total[index] / numberOfSubjects;
            System.out.println("Saving >>>>>>>>>>Saved successfully");

        }
	System.out.println("====================================================");

        System.out.println("STUDENTS\tSUB1\tSUB2\tSUB3\tSUB4\tAVERAGE\tPOSITION");



        for (int index = 0; index < numberOfStudents; index++) {
            System.out.print("Student " + (index + 1) + ": ");
            for (int count = 0; count < numberOfSubjects; count++) {
                System.out.print(scores[index][count] + "\t");
		
            }
            
            System.out.printf("%d\t%.2f\n", total[index], average[index]);  
	    
	for (int index = 0; index < average.length -1; index++){
	    average[index] = average[index] + average[index + 1]; 
            average[index + 1] = average[index] - average[index + 1]; 
            average[index] = average[index] - average[index + 1];
            position += ave

	}

	System.out.println("====================================================");
        }

        
    }
}
