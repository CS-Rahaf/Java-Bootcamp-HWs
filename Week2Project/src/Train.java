import java.time.LocalDate;
import java.time.LocalTime;

public class Train extends Trip{


    public Train(String tripNumber, double distance, double speed, String startTime, LocalDate tripDate) {
        super(tripNumber, distance, speed, startTime, tripDate);
    }

    @Override
    double calculateDuration() {
        double time = getDistance()/getSpeed();
        return time;
    }


   LocalTime stops(LocalTime localTime){


        return LocalTime.now();
    }

}
