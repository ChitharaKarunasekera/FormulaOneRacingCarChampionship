package CarChampionship;

public abstract class Formula1Driver {
    //Basic Information
    private String name;
    private String location;
    private String team;
    //Driver's statistics
    private int firstPositionCount;
    private int secondPositionCount;
    private int thirdPositionCount;
    private int points;
    private int racesCount;

    //Getter Methods
    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public String getTeam() {
        return team;
    }

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
    public void setName(String name) {
        this.name = name;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setTeam(String team) {
        this.team = team;
    }

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

    public void assigningPoints(){
        
    }
}
