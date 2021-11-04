package CarChampionship;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.LinkedBlockingDeque;

public class Formula1ChampionshipManager implements ChampionshipManager {
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

        while (true) {
            if (isTeamExisting(team)) {
                System.out.println("\nSorry! Team name already exist. Try another name");
                System.out.print("Re-enter a team name: ");
                team = input.next();
            } else {
                break;
            }
        }

        drivers.add(new Formula1Driver(name, location, team));//create new Formula1Driver object and add to array list
        System.out.println("\nDriver was added to the championship competition!\n");
    }

    @Override
    public void deleteDriver() {
        String team;
        String confirm;

        System.out.print("Enter team name of Driver: ");
        team = input.next();

        for (Formula1Driver driver : drivers) {
            //check if team name if occurred in array
            if (isTeamExisting(team)) {
                System.out.print("Driver was found. Are you sure you want to delete driver " + driver.getName() + "(Y/N)? ");
                confirm = input.next();
                if (confirm.equalsIgnoreCase("Y")) {
                    drivers.remove(driver);//access the index of particular driver and set it to null;
                    System.out.println("Driver was successfully deleted!");
                    break;
                } else {
                    System.out.println("Process cancelled! Driver was not removed.");
                }

            } else {
                System.out.println("Sorry, a driver with team name " + team + " was not found.\n");
            }
        }

    }

    @Override
    public void changeTeam() {
        String currTeam;
        String newTeam;

        System.out.print("Enter current team name: ");
        currTeam = input.next();

        //check if current team exists
        if (isTeamExisting(currTeam)) {
            System.out.println("Team name found.");
            System.out.print("Enter new team name: ");
            newTeam = input.next();

            //check if new team name already exists
            while (true) {
                if (isTeamExisting(newTeam)) {
                    System.out.println("\nSorry! Team name already exist. Try another name");
                    System.out.print("Re-enter a team name: ");
                    newTeam = input.next();
                } else {
                    //change the team name to new team name.
                    for (Formula1Driver driver : drivers) {
                        if (driver.getTeam().equalsIgnoreCase(currTeam)) {
                            driver.setTeam(newTeam);
                            System.out.println("Team name successfully changed to " + driver.getTeam() + "!");
                        }
                    }
                    break;
                }
            }
        } else {
            System.out.print("Team name not found!");
        }
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

    public boolean isTeamExisting(String team) {
        for (Formula1Driver driver : drivers) {
            if (team.equalsIgnoreCase(driver.getTeam())) {
                return true;//return true if team name was found
            }
        }
        return false;//team name not found
    }

}
