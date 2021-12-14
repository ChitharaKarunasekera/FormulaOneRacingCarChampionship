package CarChampionship;

import java.text.ParseException;

public interface ChampionshipManager {

    void addNewDriver();
    void deleteDriver();
    void changeTeam();
    void displayStatistics();
    void displayAllDrivers();
    void insertRace() throws ParseException;
    void saveToFile();
    void readFromFile();

}
