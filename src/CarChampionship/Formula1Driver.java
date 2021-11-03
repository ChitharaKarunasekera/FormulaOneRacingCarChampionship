package CarChampionship;

public class Formula1Driver {
    //Driver's statistics
    private int firstPositionCount;
    private int secondPositionCount;
    private int thirdPositionCount;
    private int points;
    private int racesCount;

    //default constructor
    public Formula1Driver(){
        this.firstPositionCount = 0;
        this.secondPositionCount = 0;
        this.thirdPositionCount = 0;
        this.points = 0;
        this.racesCount = 0;
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

    public int getRacesCount(){
        return racesCount;
    }


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

    public void setRacesCount(int count){
        this.racesCount = count;
    }


    public void calculateTotPoints(){

    }

    //Method to increase the count of points according to driver's position
    public void assigningPoints(int position){
        switch (position){
            case 1:
                points += 25;
                break;
            case 2:
                points += 18;
                break;
            case 3:
                points += 15;
                break;
            case 4:
                points += 12;
                break;
            case 5:
                points += 10;
                break;
            case 6:
                points += 8;
                break;
            case 7:
                points += 6;
                break;
            case 8:
                points += 4;
                break;
            case 9:
                points += 2;
                break;
            case 10:
                points += 1;
                break;
        }

    }
}
