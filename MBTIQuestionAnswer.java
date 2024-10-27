import java.util.Scanner;
import java.util.Arrays;

public class MBTIQuestionAnswer {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("What is your name? ");
        String name = input.nextLine().trim();
        while(name.isEmpty()){
            System.out.print("Name space is empty, try again");
            name = input.nextLine().trim();
        }

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
        
        

        String mbtiDescription = getMbtiDescription(mbti);
        System.out.println(name + ", your MBTI type is: " + mbti);
        System.out.println("Description: " + mbtiDescription);
        
   


    }



    public static void printExtrovertIntrovert(String[] userResponses, String[][] questions){
    int eCount = 0, iCount = 0;

    for (int index = 0; index < questions.length; index += 4) {
        String selectedOption = userResponses[index].equals("A") ? questions[index][0] : questions[index][1];
        System.out.println("Q" + (index + 1) + ": " + selectedOption);

    
        if (userResponses[index].equals("A")) eCount++;
        else iCount++;
    }
        System.out.println("Extrovert vs Introvert");
        System.out.println("Number of A selected: " + eCount);
        System.out.println("Number of B selected: " + iCount + "\n");
        
    }


    public static void printSensingIntuition(String[] userResponses, String[][] questions){
    int sCount = 0, nCount = 0;

    for (int index = 1; index < questions.length; index += 4) {
        String selectedOption = userResponses[index].equals("A") ? questions[index][0] : questions[index][1];
        System.out.println("Q" + (index + 1) + ": " + selectedOption);

    
        if (userResponses[index].equals("A")) sCount++;
        else nCount++;
    }
        System.out.println("Sensing vs Intuition");
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
        System.out.println("Thinking vs Feeling");
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
        System.out.println("Judging vs Perceptive");
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


    public static String getMbtiDescription(String mbti){
        switch (mbti) {
            case "INTJ": 
		return "INTJ (Architect) is a personality type with the Introverted, Intuitive, Thinking, and Judging traits. These thoughtful tacticians love perfecting the details of life, applying creativity and rationality to everything they do. Their inner world is often a private, complex one.";

            case "INFJ":
               return "INFJ (Advocate) is a personality type with the Introverted, Intuitive, Feeling, and Judging traits. They tend to approach life with deep thoughtfulness and imagination. Their inner vision, personal values, and a quiet, principled version of humanism guide them in all things.";

            case "ISTJ":
               return "ISTJ (Logistician) is a personality type with the Introverted, Observant, Thinking, and Judging traits. These people tend to be reserved yet willful, with a rational outlook on life. They compose their actions carefully and carry them out with methodical purpose.";

            case "ISTP":
                return "ISTP (Virtuoso) is a personality type with the Introverted, Observant, Thinking, and Prospecting traits. They tend to have an individualistic mindset, pursuing goals without needing much external connection. They engage in life with inquisitiveness and personal skill, varying their approach as needed.";

            case "INTP":
                return "INTP (Logician) is a personality type with the Introverted, Intuitive, Thinking, and Prospecting traits. These flexible thinkers enjoy taking an unconventional approach to many aspects of life. They often seek out unlikely paths, mixing willingness to experiment with personal creativity.";

            case "ENFJ":
                return "ENFJ (Protagonist) is a personality type with the Extraverted, Intuitive, Feeling, and Judging traits. These warm, forthright types love helping others, and they tend to have strong ideas and values. They back their perspective with the creative energy to achieve their goals. When ENFJs care about someone, they want to help solve that person’s problems – sometimes at any cost. The good news is that many people are grateful for this assistance and advice. After all, there’s a reason that these personalities have a reputation for helping others improve their lives. People with the ENFJ personality type (Protagonists) feel called to serve a greater purpose in life. Thoughtful and idealistic, ENFJs strive to have a positive impact on other people and the world around them. These personalities rarely shy away from an opportunity to do the right thing, even when doing so is far from easy.";

            case "ENFP":
                return "ENFP (Campaigner) is a personality type with the Extraverted, Intuitive, Feeling, and Prospecting traits. These people tend to embrace big ideas and actions that reflect their sense of hope and goodwill toward others. Their vibrant energy can flow in many directions.";

	    case "ENTJ":
                return "ENTJ (Commander) is a personality type with the Extraverted, Intuitive, Thinking, and Judging traits. They are decisive people who love momentum and accomplishment. They gather information to construct their creative visions but rarely hesitate for long before acting on them.";

            case "ENTP":
                return "ENTP (Debater) is a personality type with the Extraverted, Intuitive, Thinking, and Prospecting traits. They tend to be bold and creative, deconstructing and rebuilding ideas with great mental agility. They pursue their goals vigorously despite any resistance they might encounter.";

	    case "INFP":
                return "INFP (Mediator) is a personality type with the Introverted, Intuitive, Feeling, and Prospecting traits. These rare personality types tend to be quiet, open-minded, and imaginative, and they apply a caring and creative approach to everything they do.";

 	    case "ISFJ":
                return "ISFJ (Defender) is a personality type with the Introverted, Observant, Feeling, and Judging traits. These people tend to be warm and unassuming in their own steady way. They’re efficient and responsible, giving careful attention to practical details in their daily lives.";

	    case "ESTJ":
                return "ESTJ (Executive) is a personality type with the Extraverted, Observant, Thinking, and Judging traits. They possess great fortitude, emphatically following their own sensible judgment. They often serve as a stabilizing force among others, able to offer solid direction amid adversity.";


	    case "ESFJ":
                return "ESFJ (Consul) is a personality type with the Extraverted, Observant, Feeling, and Judging traits. They are attentive and people-focused, and they enjoy taking part in their social community. Their achievements are guided by decisive values, and they willingly offer guidance to others.";


            case "ISFP":
                return "ISFP (Adventurer) is a personality type with the Introverted, Observant, Feeling, and Prospecting traits. They tend to have open minds, approaching life, new experiences, and people with grounded warmth. Their ability to stay in the moment helps them uncover exciting potentials.";


	    case "ESTP":
                return "ESTP (Entrepreneur) is a personality type with the Extraverted, Observant, Thinking, and Prospecting traits. They tend to be energetic and action-oriented, deftly navigating whatever is in front of them. They love uncovering life’s opportunities, whether socializing with others or in more personal pursuits.";


	    case "ESFP":
                return "ESFP (Entertainer) is a personality type with the Extraverted, Observant, Feeling, and Prospecting traits. These people love vibrant experiences, engaging in life eagerly and taking pleasure in discovering the unknown. They can be very social, often encouraging others into shared activities.";


	    default:
                return "A very special and interesting personality";


        }



    }


}
