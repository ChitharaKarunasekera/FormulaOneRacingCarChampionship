package CarChampionship;

public class Formula1Driver extends Driver {
    //Driver's statistics
    private int firstPositionCount;
    private int secondPositionCount;
    private int thirdPositionCount;
    private int points;
    private int racesCount;

    //default constructor
    public Formula1Driver(String name, String location, String team) {
        super(name, location, team);//call constructor of Driver class and assign basic information
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

    public int getRacesCount() {
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

    public void setRacesCount(int count) {
        this.racesCount = count;
    }


    //Method to increase the count of points according to driver's position
    public void assigningPoints(int position) {
        switch (position) {
            case 1:
                this.points += 25;
                countPositions(position);
                break;
            case 2:
                this.points += 18;
                countPositions(position);
                break;
            case 3:
                this.points += 15;
                countPositions(position);
                break;
            case 4:
                this.points += 12;
                break;
            case 5:
                this.points += 10;
                break;
            case 6:
                this.points += 8;
                break;
            case 7:
                this.points += 6;
                break;
            case 8:
                this.points += 4;
                break;
            case 9:
                this.points += 2;
                break;
            case 10:
                this.points += 1;
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
}
