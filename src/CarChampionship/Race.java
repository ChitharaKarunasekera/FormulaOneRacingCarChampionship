package CarChampionship;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Race {
    static int raceNumber= 0;
    private LocalDateTime dateTime;
    private int noOfDrivers;

    public Race(LocalDateTime dateTime, int noOfDrivers){
        ++raceNumber;
        this.dateTime = dateTime;
        this.noOfDrivers = noOfDrivers;
    }

    //Getters
    public int getRaceNumber() {
        return raceNumber;
    }

    public String getDateTime() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        return formatter.format(dateTime);
    }

    public int getNoOfDrivers() {
        return noOfDrivers;
    }


    //setters
    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public void setNoOfDrivers(int noOfDrivers) {
        this.noOfDrivers = noOfDrivers;
    }
}
