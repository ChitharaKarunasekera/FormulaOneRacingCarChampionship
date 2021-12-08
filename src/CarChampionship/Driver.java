package CarChampionship;

import java.io.Serializable;

<<<<<<< HEAD
public abstract class Driver {
=======
public abstract class Driver implements Serializable {
>>>>>>> Section3-Serialization
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
}
