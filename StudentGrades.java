import java.util.Scanner;

public class StudentGrades {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        System.out.print("Enter the number of students: ");
        int numStudents = scanner.nextInt();

        System.out.print("Enter the number of subjects: ");
        int numSubjects = scanner.nextInt();


        int[][] scores = new int[numStudents][numSubjects];


        for (int index = 0; index < numStudents; index++) {  
            System.out.println("Enter scores for Student " + (index + 1) + ":");
            for (int count = 0; count < numSubjects; count++) {  
                System.out.print("  Score for Subject " + (count + 1) + ": ");
                scores[index][count] = scanner.nextInt(); 
            }
        }

        System.out.println("\nCollected Scores:");
        for (int index = 0; index < numStudents; index++) {
            System.out.print("Student " + (index + 1) + ": ");
            for (int count = 0; count < numSubjects; count++) {
                System.out.print(scores[index][count] + " ");
            }
            System.out.println();  
        }

    }



}
