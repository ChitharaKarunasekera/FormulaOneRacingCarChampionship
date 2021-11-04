package CarChampionship;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.LinkedBlockingDeque;

public class Formula1ChampionshipManager implements ChampionshipManager{
    Scanner input = new Scanner(System.in);

    ArrayList<Formula1Driver> drivers = new ArrayList<Formula1Driver>();//All divers participating in championship

    public void addNewDriver() {
        String name;
        String location;
        String team;

        System.out.print("Enter name of Driver: ");
        name = input.next();
        System.out.print("Enter location of Driver: ");
        location = input.next();
        System.out.print("Enter Team of Driver: ");
        team = input.next();

        drivers.add(new Formula1Driver(name, location, team));//create new Formula1Driver object and add to array list
    }

    @Override
    public void deleteDriver() {
        String team;
        String confirm;

        System.out.print("Enter team name of Driver: ");
        team = input.next();

        for (Formula1Driver driver : drivers){
            //check if team name if occurred in array
            if (team.equalsIgnoreCase(driver.getTeam())){
                System.out.println("Driver was found. Are you sure you want to delete driver " + driver.getName() + "(Y/N)? ");
                confirm = input.next();
                if (confirm.equalsIgnoreCase("Y")){
                    drivers.remove(driver);//access the index of particular driver and set it to null;
                    System.out.println("Driver was successfully deleted!");
                    break;
                }
                else {
                    System.out.println("Process cancelled! Driver was not removed.");
                }

            }
            else {
                System.out.println("Sorry, a driver with team name " + team + " was not found.\n");
            }
        }

    }

    @Override
    public void changeTeam() {

    }

    @Override
    public void displayStatistics() {

    }

    @Override
    public void displayAllDrivers() {

    }

    @Override
    public void raceStatistics() {

    }

    @Override
    public void saveToFile() {

    }

    @Override
    public void readFromFile() {

    }
}
