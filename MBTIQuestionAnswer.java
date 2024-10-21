import java.util.Scanner;
import java.util.Arrays;

public class MBTIQuestionAnswer {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("What is your name? ");
        String name = input.nextLine();

        int eCount = 0, iCount = 0;
        int sCount = 0, nCount = 0;
        int tCount = 0, fCount = 0;
        int jCount = 0, pCount = 0;

        

        
        String[] userResponses = new String[20];

        System.out.println("\nHello, " + name + "! Kindly answer each question with 'A' or 'B' to determine your personality.\n");

        String[][] questions = {
            { "A) Expend energy, enjoy groups", "B) Conserve energy, enjoy one on one" },  
            { "A) Interpret literally", "B) Look for meaning and possibilities" },  
            { "A) Logical, thinking, questioning", "B) Empathetic, feeling, accommodating" },  
            { "A) Organized, orderly", "B) Flexible, adaptable" },  
            { "A) More outgoing, think out loud", "B) More reserved, think to yourself" },  
            { "A) Practical, realistic, experiential", "B) Imaginative, innovative, theoretical" },  
            { "A) Candid, straightforward, frank", "B) Tactful, kind, encouraging" },  
            { "A) Plan, schedule", "B) Unplanned, spontaneous" },  
            { "A) Seek many tasks, public activities, interaction with others", 
              "B) Seek private, solitary activities with quiet to concentrate" },  
            { "A) Standard, usual, conventional", "B) Different, novel, unique" },  
            { "A) Firm, tend to criticize, hold the line", "B) Gentle, tend to appreciate, conciliate" },  
            { "A) Regulated, structured", "B) Easygoing, 'live and let live'" },  
            { "A) External, communicative, express yourself", 
              "B) Internal, reticent, keep to yourself" },  
            { "A) Focus on here-and-now", 
              "B) Look to the future, global perspective, 'big picture'" },  
            { "A) Tough-minded, just", "B) Tender-hearted, merciful" },  
            { "A) Preparation, plan ahead", "B) Go with the flow, adapt as you go" }, 
            { "A) Active, initiate", "B) Reflective, deliberate" }, 
            { "A) Facts, things, 'what is'", "B) Ideas, dreams, 'what could be', philosophical" },  
            { "A) Matter-of-fact, issue-oriented", "B) Sensitive, people-oriented, compassionate" },  
            { "A) Control, govern", "B) Latitude, freedom" }  

     };

        for (int index = 0; index < questions.length; index++) {
            System.out.println("Q" + (index + 1) + ": " + questions[index][0] + "\t" + questions[index][1]);

            String response = checkResponse(input); 
            userResponses[index] = response;

           
            if (index % 4 == 0) { 
                if (response.equals("A")) eCount++;  
                else iCount++;
            } 
            if (index % 4 == 1) { 
                if (response.equals("A")) sCount++; 
                else nCount++; 
                

            }
            if (index % 4 == 2) { 
                if (response.equals("A")) tCount++; 
                else fCount++; 

            }
            if (index % 4 == 3) { 
                if (response.equals("A")) jCount++; 
                else pCount++; 


            }

            
        }

        String mbti = "";
        mbti += (eCount >= iCount) ? "E" : "I"; 
        mbti += (sCount >= nCount) ? "S" : "N";  
        mbti += (tCount >= fCount) ? "T" : "F";  
        mbti += (jCount >= pCount) ? "J" : "P";  

		
        System.out.println("\nHello " + name + ", you selected");

        printExtrovertIntrovert(userResponses, questions);
        printSensingIntuition(userResponses, questions);
        printThinkingFeeling(userResponses, questions);
        printJudgingPerceptive(userResponses, questions);
        
        System.out.println("\n" + name + ", your MBTI type is: " + mbti);

    }



    public static void printExtrovertIntrovert(String[] userResponses, String[][] questions){
    int eCount = 0, iCount = 0;

    for (int index = 0; index < questions.length; index += 4) {
        String selectedOption = userResponses[index].equals("A") ? questions[index][0] : questions[index][1];
        System.out.println("Q" + (index + 1) + ": " + selectedOption);

    
        if (userResponses[index].equals("A")) eCount++;
        else iCount++;
    }
        System.out.println("Number of A selelected: " + eCount);
        System.out.println("Number of B selelected: " + iCount + "\n");
        
    }


    public static void printSensingIntuition(String[] userResponses, String[][] questions){
    int sCount = 0, nCount = 0;

    for (int index = 1; index < questions.length; index += 4) {
        String selectedOption = userResponses[index].equals("A") ? questions[index][0] : questions[index][1];
        System.out.println("Q" + (index + 1) + ": " + selectedOption);

    
        if (userResponses[index].equals("A")) sCount++;
        else nCount++;
    }
        System.out.println("Number of A selelected: " + sCount);
        System.out.println("Number of B selelected: " + nCount+ "\n");
      
    }


    public static void printThinkingFeeling(String[] userResponses, String[][] questions){
    int tCount = 0, fCount = 0;

    for (int index = 2; index < questions.length; index += 4) {
        String selectedOption = userResponses[index].equals("A") ? questions[index][0] : questions[index][1];
        System.out.println("Q" + (index + 1) + ": " + selectedOption);

    
        if (userResponses[index].equals("A")) tCount++;
        else fCount++;
    }
        System.out.println("Number of A selelected: " + tCount);
        System.out.println("Number of B selelected: " + fCount + "\n");
       
    }

    public static void printJudgingPerceptive(String[] userResponses, String[][] questions){
    int jCount = 0, pCount = 0;

    for (int index = 3; index < questions.length; index += 4) {
        String selectedOption = userResponses[index].equals("A") ? questions[index][0] : questions[index][1];
        System.out.println("Q" + (index + 1) + ": " + selectedOption);

    
        if (userResponses[index].equals("A")) jCount++;
        else pCount++;
    }
        System.out.println("Number of A selelected: " + jCount);
        System.out.println("Number of B selelected: " + pCount + "\n");
        
    }


    private static String checkResponse(Scanner input) {
        String response;
        while (true) {
            response = input.nextLine().trim().toUpperCase();

            if (response.equals("A") || response.equals("B")) {
                return response;  
            } 
            else {
                System.out.println("Invalid input. Please enter 'A' or 'B'.");
            }
        }
    }
}
