package CarChampionship;

public class Race {
    private int raceNumber;
    private String dateTime;
    private int noOfDrivers;

    public Race(int raceNumber, String dateTime, int noOfDrivers){
        this.raceNumber = raceNumber;
        this.dateTime = dateTime;
        this.noOfDrivers = noOfDrivers;
    }

    //Getters
    public int getRaceNumber() {
        return raceNumber;
    }

    public String getDateTime() {
        return dateTime;
    }

    public int getNoOfDrivers() {
        return noOfDrivers;
    }

    //Setters
    public void setRaceNumber(int raceNumber) {
        this.raceNumber = raceNumber;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public void setNoOfDrivers(int noOfDrivers) {
        this.noOfDrivers = noOfDrivers;
    }
}
