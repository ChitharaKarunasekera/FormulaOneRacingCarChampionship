package CarChampionship;

import java.time.LocalDateTime;

public class Race {
    private int raceNumber = 0;
    private LocalDateTime dateTime;
    private int noOfDrivers;

    public Race(LocalDateTime dateTime, int noOfDrivers){
        this.raceNumber = raceNumber;
        this.dateTime = dateTime;
        this.noOfDrivers = noOfDrivers;
    }

    //Getters
    public int getRaceNumber() {
        return raceNumber;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public int getNoOfDrivers() {
        return noOfDrivers;
    }

    //Setters
    public void setRaceNumber(int raceNumber) {
        this.raceNumber = raceNumber;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public void setNoOfDrivers(int noOfDrivers) {
        this.noOfDrivers = noOfDrivers;
    }
}
