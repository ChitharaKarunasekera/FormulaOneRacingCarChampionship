package CarChampionship;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Race implements Serializable { //implements Comparable<Race>
    public static final long serialVersionID = 1L;

    private int raceId;
    static int noOfRaces = 0;
    private LocalDateTime dateTime;
    private int noOfDrivers;
    private ArrayList<Formula1Driver> driverList;

    public Race(LocalDateTime dateTime, int noOfDrivers, ArrayList<Formula1Driver> driverList){
        ++noOfRaces;
        this.dateTime = dateTime;
        this.noOfDrivers = noOfDrivers;
    }

    //Getters
    public int getNofRaces() {
        return noOfRaces;
    }

    public String getDateTime() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        return formatter.format(dateTime);
    }

    public int getNoOfDrivers() {
        return noOfDrivers;
    }

    public int getRaceId(){
        return raceId;
    }


    //setters
    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public void setNoOfDrivers(int noOfDrivers) {
        this.noOfDrivers = noOfDrivers;
    }

    public void setRaceId(int raceId) {
        this.raceId = raceId;
    }



//    @Override
//    public int compareTo(Race o) {
//        if (this.dateTime > o.dateTime){
//            return -1;
//        }
//        //if this drivers points are less than the other drivers points return 1
//        else if (this.dateTime < o.dateTime){
//            return 1;
//        }
//        //if this drivers points and the other drivers points are equal check,
//        else{
//    }
}
