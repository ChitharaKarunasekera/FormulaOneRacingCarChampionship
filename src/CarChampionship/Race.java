package CarChampionship;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Race { //implements Comparable<Race>
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
