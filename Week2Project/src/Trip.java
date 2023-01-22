import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public abstract class Trip {

    private String tripNumber;
    private double distance;
    private double speed;
    private String startTime;
    private LocalDate tripDate;


    public Trip(String tripNumber, double distance, double speed, String startTime, LocalDate tripDate) {
        this.tripNumber = tripNumber;
        this.distance = distance;
        this.speed = speed;
        this.startTime = startTime;
        this.tripDate=tripDate;
    }

    abstract double calculateDuration();
     int convertMinToHour(int min){
         int hours = (int)Math.round(min / 60.0);
         return hours;
     }

    int convertHourToMin(double hours){
        int mins = (int)Math.round(hours * 60);
        return mins;
    }

    String calculateArrivalTime(){
        LocalTime startTime1= LocalTime.of(Integer.parseInt(startTime.split(":")[0]),Integer.parseInt(startTime.split(":")[1]));

        double duration= calculateDuration();
        int durationHours = ((int) duration);
        double fractional= duration - durationHours ;
        double scale = Math.pow(10, 2);
        double durationMinsPart= Math.round(fractional * scale) / scale;
        int durationMin = convertHourToMin(durationMinsPart);

        LocalTime arrivalTime= startTime1.plusHours(Long.valueOf(durationHours)).plusMinutes(Long.valueOf(durationMin));

        return arrivalTime+"";
    }

    int daysCounter (){
         LocalDate today = LocalDate.now();
         Long numberOfDays= ChronoUnit.DAYS.between(today, tripDate);
         return Math.toIntExact(numberOfDays);
    }

    public String getTripNumber() {
        return tripNumber;
    }

    public void setTripNumber(String tripNumber) {
        this.tripNumber = tripNumber;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public LocalDate getTripDate() {
        return tripDate;
    }

    public void setTripDate(LocalDate tripDate) {
        this.tripDate = tripDate;
    }
}
