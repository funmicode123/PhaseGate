import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class MenstrualApp {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        System.out.print("Welcome to FlowMenstrual App, what is your name? ");
        String name = input.nextLine();

        System.out.print("What is your age? ");
        int age = input.nextInt();
        input.nextLine();  

        System.out.print("Enter the last period start date (yyyy-MM-dd): ");
        LocalDate lastPeriodStart = LocalDate.parse(input.nextLine(), dateFormat);

        int cycleLength;
        while (true) {
            System.out.print("Enter the cycle length (21-35 days): ");
            cycleLength = input.nextInt();
            input.nextLine();
            if (cycleLength >= 21 && cycleLength <= 35) {
                break;
            } else {
                System.out.println("The cycle length is outside the normal range. Please consult a gynecologist.");
            }
        }

        System.out.print("Enter the period duration: ");
        int periodDuration = input.nextInt();

        LocalDate resultNextPeriod = checkNextPeriod(lastPeriodStart, cycleLength);
        System.out.println("Next Period: " + resultNextPeriod);

        LocalDate resultOvulationDay = checkOvulationDay(resultNextPeriod);
        System.out.println("Ovulation Day: " + resultOvulationDay);

        String resultFertilityWindow = checkFertilityWindow(resultOvulationDay);
        System.out.println("Fertile Window: " + resultFertilityWindow);

        LocalDate resultPeriodEnd = checkPeriodEnd(lastPeriodStart, periodDuration);
        System.out.println("Expected Period End: " + resultPeriodEnd);
    }

    public static LocalDate checkNextPeriod(LocalDate lastPeriodStart, int cycleLength){
        return lastPeriodStart.plusDays(cycleLength);
    }

    public static LocalDate checkOvulationDay(LocalDate resultNextPeriod){
        return resultNextPeriod.minusDays(14);
    }

    public static String checkFertilityWindow(LocalDate resultOvulationDay){
        LocalDate fertileStart = resultOvulationDay.minusDays(5);
        LocalDate fertileEnd = resultOvulationDay.plusDays(1);
        return fertileStart + " to " + fertileEnd;
    }

    public static LocalDate checkPeriodEnd(LocalDate lastPeriodStart, int periodDuration){
        return lastPeriodStart.plusDays(periodDuration - 1);
    }
}
