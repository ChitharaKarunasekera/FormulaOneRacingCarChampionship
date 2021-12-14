package CarChampionship;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;

public class Race implements Serializable { //implements Comparable<Race>
    public static final long serialVersionID = 1L;

    private int raceId;
    static int noOfRaces = 0;
    private Date date;
    private int noOfDrivers;
    private boolean automatic;
    private ArrayList<Formula1Driver> driverList;

    public Race(Date date, int noOfDrivers, ArrayList<Formula1Driver> driverList){
        ++noOfRaces;
        this.date = date;
        this.noOfDrivers = noOfDrivers;
    }

    //Getters
    public int getNofRaces() {
        return noOfRaces;
    }

    public String getDate() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
        return formatter.format(date);
    }

    public int getNoOfDrivers() {
        return noOfDrivers;
    }

    public int getRaceId(){
        return raceId;
    }

    public boolean isAutomatic(){
        return automatic;
    }


    //setters
    public void setDate(Date date) {
        this.date = date;
    }

    public void setNoOfDrivers(int noOfDrivers) {
        this.noOfDrivers = noOfDrivers;
    }

    public void setRaceId(int raceId) {
        this.raceId = raceId;
    }

    public void setAutomatic(Boolean automatic){
        this.automatic = automatic;
    }
}
