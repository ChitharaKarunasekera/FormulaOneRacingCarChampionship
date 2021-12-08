package CarChampionship;

import java.util.ArrayList;

public class SaveData implements java.io.Serializable{
    public static final long serialVersionID = 1L;

    public ArrayList<Formula1Driver> drivers;
    public ArrayList<Race> races;
}
