
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {


        Airplane airplane=new Airplane("4",400.0,250,"23:00" , LocalDate.of(2023,03,02));
        System.out.println("The plane is taking off at: " + airplane.getStartTime());
        System.out.println("The plane is landing at: " + airplane.calculateArrivalTime());
        System.out.println("Number of days to the trip date: " + airplane.daysCounter());

    }



}