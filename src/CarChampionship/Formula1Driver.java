package CarChampionship;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;

<<<<<<< HEAD
public class Formula1Driver extends Driver implements Comparable<Formula1Driver> {
=======
public class Formula1Driver extends Driver implements Comparable<Formula1Driver>, Serializable {
>>>>>>> Section3-Serialization
    public static final long serialVersionID = 1L;

    //Driver's statistics
    private int firstPositionCount;
    private int secondPositionCount;
    private int thirdPositionCount;
    private int points;
    private int racesCount;
    private int currentPosition;
    private int startingPosition;
    private ArrayList<Integer> racesParticipated = new ArrayList<>();

    Random rand = new Random();//to generate a random number

    //default constructor
    public Formula1Driver(String name, String location, String team) {
        super(name, location, team);//call constructor of Driver class and assign basic information
        this.firstPositionCount = 0; //rand.nextInt(5);;
        this.secondPositionCount = 0;
        this.thirdPositionCount = 0;
        this.points = 0; //rand.nextInt(3);//generates a random number between 0 - 10
        this.racesCount = 0;
    }

    public Formula1Driver(String name, String location, String team, int firstPositionCount, int secondPositionCount, int thirdPositionCount, int points, int racesCount, int currentPosition) {
        super(name, location, team);//call constructor of Driver class and assign basic information
        this.firstPositionCount = firstPositionCount;
        this.secondPositionCount = secondPositionCount;
        this.thirdPositionCount = thirdPositionCount;
        this.points = points;
        this.racesCount = racesCount;
        this.currentPosition = currentPosition;
    }

    //Getter Methods
    public int getFirstPositionCount() {
        return firstPositionCount;
    }

    public int getSecondPositionCount() {
        return secondPositionCount;
    }

    public int getThirdPositionCount() {
        return thirdPositionCount;
    }

    public int getPoints() {
        return points;
    }

    public int getRacesCount() {
        return racesCount;
    }

    public int getCurrentPositions(){
        return currentPosition;
    }

    //returns races participated
    public ArrayList<Integer> getRacesParticipated() { return racesParticipated; }


    //Setter Methods
    public void setFirstPositionCount(int firstPositionCount) {
        this.firstPositionCount = firstPositionCount;
    }

    public void setSecondPositionCount(int secondPositionCount) {
        this.secondPositionCount = secondPositionCount;
    }

    public void setThirdPositionCount(int thirdPositionCount) {
        this.thirdPositionCount = thirdPositionCount;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public void setRacesCount(int count) {
        this.racesCount = count;
    }

    public void setRacesParticipated(int raceId) {
        racesParticipated.add(raceId);//add the race id to races list
    }

    //Once a race is completed, the driver will be awarded a random position according to the count of drivers participated
    public void setCurrentPosition(int currentPosition){
        this.currentPosition = currentPosition;
    }

//    public void setStartingPosition(int startingPosition) {
//        this.startingPosition = startingPosition;
//    }

    //set a starting position for the driver
    public void setStartingPosition(int startingPosition){
        this.startingPosition = startingPosition;
    }

    public int getStartingPosition(){
        return this.startingPosition;
    }

    //Method to increase the count of points according to driver's position
    public void assigningPoints(int position) {
        switch (position) {
            case 1:
                this.points += 25;
                this.racesCount += 1;//count participation
                countPositions(position);//automatically increment count of 1st positions by one
                break;
            case 2:
                this.points += 18;
                this.racesCount += 1;//count participation
                countPositions(position);//automatically increment count of 2nd positions by one
                break;
            case 3:
                this.points += 15;
                this.racesCount += 1;//count participation
                countPositions(position);//automatically increment count of 3rd positions by one
                break;
            case 4:
                this.points += 12;
                this.racesCount += 1;//count participation
                break;
            case 5:
                this.points += 10;
                this.racesCount += 1;//count participation
                break;
            case 6:
                this.points += 8;
                this.racesCount += 1;//count participation
                break;
            case 7:
                this.points += 6;
                this.racesCount += 1;//count participation
                break;
            case 8:
                this.points += 4;
                this.racesCount += 1;//count participation
                break;
            case 9:
                this.points += 2;
                this.racesCount += 1;//count participation
                break;
            case 10:
                this.points += 1;
                this.racesCount += 1;//count participation
                break;
        }
    }

    //Increase first, second or third position count by one
    public void countPositions(int position) {
        if (position == 1) {
            this.firstPositionCount += 1;
        } else if (position == 2) {
            this.secondPositionCount += 1;
        } else if (position == 3) {
            this.thirdPositionCount += 1;
        }
    }

    //implementation of compareTo() method of Comparable interface. This method is to sort drivers in descending order according to points
    public int compareTo(Formula1Driver o)
    {
        //if this drivers points are greater than the other drivers points return -1
        if (this.points > o.points){
            return -1;
        }
        //if this drivers points are less than the other drivers points return 1
        else if (this.points < o.points){
            return 1;
        }
        //if this drivers points and the other drivers points are equal check,
        else{
            //if this drivers has won more 1st places than the other, then return -1
            if (this.getFirstPositionCount() > o.getFirstPositionCount()){
                return -1;
            }
            //if other drivers has won more 1st places than the this driver, then return 1
            else if (this.getFirstPositionCount() < o.getFirstPositionCount()){
                return 1;
            }
            //if 1st position count of both drivers are equal return 0
            else {
                return 0;
            }
        }
    }
}
