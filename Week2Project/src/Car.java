import java.time.LocalDate;

public class Car extends Trip{


    public Car(String tripNumber, double distance, double speed, String startTime, LocalDate tripDate) {
        super(tripNumber, distance, speed, startTime, tripDate);
    }

    @Override
    double calculateDuration() {
        double time = getDistance()/getSpeed();
        return time;
    }


}
