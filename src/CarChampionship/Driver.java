package CarChampionship;

public abstract class Driver {
    //Basic Information
    private String name;
    private String location;
    private String team;

    //overloaded constructor
    public Driver(String name, String location, String team){
        this.name = name;
        this.location = location;
        this.team = team;
    }

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


    //getters of Formula1Driver
    abstract public int getFirstPositionCount();
    abstract public int getSecondPositionCount();
    abstract public int getThirdPositionCount();
    abstract public int getPoints();
    abstract public int getRacesCount();

    abstract public void setFirstPositionCount(int firstPositionCount);
    abstract public void setSecondPositionCount(int secondPositionCount);
    abstract public void setThirdPositionCount(int thirdPositionCount);
    abstract public void setPoints(int points);
    abstract public void setRacesCount(int count);

    abstract public void assigningPoints(int position);
    //abstract public void countPositions(int position);
}
