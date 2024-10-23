import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class MenstrualApp {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        System.out.print("Welcome to FlowMenstral App is your name? ");
        String name = input.nextLine();

        System.out.print("What is your age? ");
        int age = input.nextInt();
        input.nextLine();  

        System.out.print("Enter the last period start date (yyyy-MM-dd): ");
        LocalDate lastPeriodStart = LocalDate.parse(input.nextLine(), dateFormat);

        System.out.print("Enter the cycle length: ");
        int cycleLength = input.nextInt();
        input.nextLine();  

        System.out.print("Enter the period duration: ");
        int periodDuration = input.nextInt();

        LocalDate resultNextPeriod = checkNextPeriod(lastPeriodStart, cycleLength);
        System.out.println("Next Period: " + resultNextPeriod);

	LocalDate resultOvulationDay = checkOvulationDay(resultNextPeriod);
        System.out.println("Ovulation Day: " + resultOvulationDay);

	String resultFertilityWindow = checkFertilityWindow(resultOvulationDay, periodDuration);
	System.out.println("Fertile Window: " + resultFertilityWindow);

        LocalDate resultPeriodEnd = checkPeriodEnd(lastPeriodStart, periodDuration);
        System.out.println("Expected Period End: " + resultPeriodEnd);

        }
        public static LocalDate checkNextPeriod(LocalDate lastPeriodStart, int cycleLength){
            LocalDate nextPeriod = lastPeriodStart.plusDays(cycleLength);

            return nextPeriod;

        }

        public static LocalDate checkOvulationDay(LocalDate resultNextPeriod){
            LocalDate ovulationDay = resultNextPeriod.minusDays(14);

            return ovulationDay;

        }

	public static String checkFertilityWindow(LocalDate resultOvulationDay, int periodDuration){
            LocalDate fertileStart = resultOvulationDay.minusDays(periodDuration);
            LocalDate fertileEnd = resultOvulationDay.plusDays(1);
        
            return fertileStart + " to " + fertileEnd;
	}

        public static LocalDate checkPeriodEnd(LocalDate lastPeriodStart, int periodDuration){
            LocalDate periodEnd = lastPeriodStart.plusDays(periodDuration - 1);

            return periodEnd;
        }
}
