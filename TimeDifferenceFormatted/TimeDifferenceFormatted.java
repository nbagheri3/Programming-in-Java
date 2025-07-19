import java.sql.SQLOutput;
import java.time.Duration;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;


public class TimeDifferenceFormatted {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HHmm");

        System.out.println("Please enter the first time: ");
        String time1Str = input.nextLine();
        System.out.println("Please enter the second time: ");
        String time2Str = input.nextLine();

        LocalTime time1 = LocalTime.parse(time1Str, formatter);
        LocalTime time2 = LocalTime.parse(time2Str, formatter);

        Duration duration = Duration.between(time1, time2);

        // If the result is negative, it means time2 is on the next day
        if (duration.isNegative()) {
            duration = duration.plusHours(24);
        }

        long hours = duration.toHours();
        long minutes = duration.toMinutes() % 60;

        System.out.println(hours + " hours " + minutes + " minutes");




    }
}