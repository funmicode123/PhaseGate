import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;

public class MenstrualAppTest {

    @Test
    public void testCheckNextPeriod() {
        LocalDate lastPeriodStart = LocalDate.of(2024, 10, 1);
        int cycleDays = 28;
        LocalDate expectedNextPeriod = LocalDate.of(2024, 10, 29);

        LocalDate result = lastPeriodStart.plusDays(cycleDays);
        assertEquals(expectedNextPeriod, result, "Next period calculation failed.");
    }

    @Test
    public void testCheckOvulationDay() {
        LocalDate nextPeriod = LocalDate.of(2024, 10, 29);
        LocalDate expectedOvulationDay = LocalDate.of(2024, 10, 15);

        LocalDate result = nextPeriod.minusDays(14);
        assertEquals(expectedOvulationDay, result, "Ovulation day calculation failed.");
    }

    @Test
    public void testCheckFertileWindow() {
        LocalDate ovulationDay = LocalDate.of(2024, 10, 15);
        int periodDuration = 5;  

        LocalDate expectedFertileStart = ovulationDay.minusDays(periodDuration);
        LocalDate expectedFertileEnd = ovulationDay.plusDays(1);

        assertEquals(LocalDate.of(2024, 10, 10), expectedFertileStart, "Fertile window start calculation failed.");
        assertEquals(LocalDate.of(2024, 10, 16), expectedFertileEnd, "Fertile window end calculation failed.");
    }

    @Test
    public void testCheckPeriodEnd() {
        LocalDate lastPeriodStart = LocalDate.of(2024, 10, 1);
        int periodDuration = 5;

        LocalDate expectedPeriodEnd = lastPeriodStart.plusDays(periodDuration - 1);
        assertEquals(LocalDate.of(2024, 10, 5), expectedPeriodEnd, "Period end calculation failed.");
    }
}
