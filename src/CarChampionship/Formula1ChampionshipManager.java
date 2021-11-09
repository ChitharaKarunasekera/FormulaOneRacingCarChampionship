package CarChampionship;

import java.util.Collections;
import java.util.Comparator;
import javax.naming.PartialResultException;
import java.util.ArrayList;
import java.util.Scanner;

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
        String team;
        int index;

        System.out.print("Enter team of driver: ");
        team = input.next();

        if (getDriverIndex(team) != -1) {
            index = getDriverIndex(team);

            System.out.println("\nStatistics of Driver.\n" +
                    "_________________________");
            System.out.println("Team Name : " + drivers.get(index).getTeam());
            System.out.println("Driver's Name : " + drivers.get(index).getName());
            System.out.println("Driver's Location : " + drivers.get(index).getLocation());
            System.out.println("Count of 1st positions won : " + drivers.get(index).getFirstPositionCount());
            System.out.println("Count of 2nd positions won : " + drivers.get(index).getSecondPositionCount());
            System.out.println("Count of 3rd positions won : " + drivers.get(index).getThirdPositionCount());
            System.out.println("Total points : " + drivers.get(index).getPoints());
            System.out.println("Total number of races completed : " + drivers.get(index).getRacesCount());
        } else {
            System.out.println("Sorry, Team does not exist!");
        }
    }

    @Override
    public void displayAllDrivers() {

        System.out.println("|  Driver Name  |  Team Name  |  1st positions  |  2nd positions  |  3rd positions  |  Total points  |  Completed Races  |\n");

        //Sort the drivers in Descending order of their points
        Collections.sort(drivers);

        //Display all drivers in table
        for (Formula1Driver driver : drivers){

            System.out.println("|\t" + driver.getName() +
                    "\t|\t"  + driver.getTeam() +
                    "\t|\t"  + driver.getFirstPositionCount() +
                    "\t|\t" + driver.getSecondPositionCount()  +
                    "\t|\t" + driver.getThirdPositionCount() +
                    "\t|\t" + driver.getPoints() +
                    "\t|\t" + driver.getRacesCount() + 	"\t|"
            );
            System.out.println("");
        }

//        //Arranging ArrayList in descending order according to driver points --> with Insertion Sort Algorithm
//        for (int step=1; step<drivers.size(); step++){
//            Formula1Driver key = drivers.get(step);//points of driver at index step.
//            int j = step-1;//index track of leftmost driver before key driver
//
//            //until key is less than the one before it. Compare the points of key driver and one in left to it.
//            while (j>=0 && key.getPoints() > drivers.get(j).getPoints()){
//                drivers.set(j+1,drivers.get(j));//make driver in index step to driver in index j
//                j--;//decrees j by one
//            }
//            drivers.set(j+1, key);//make key driver after the driver with next smaller points.
//        }

//        //simple swap if the points are equal. If equal numbers appear, they will be to gather as the array is already sorted.
//        for (int i=0; i<drivers.size()-1; i++){
//            for (int j=0; j<drivers.size()-i-1; j++){
//                if (drivers.get(j).getPoints() == drivers.get(j+1).getPoints()){
//                    //place the driver with most 1st positions before if equal points exist.
//                    if (drivers.get(j).getFirstPositionCount() < drivers.get(j+1).getFirstPositionCount()){
//                        Formula1Driver temp = drivers.get(j);
//                        drivers.set(j, drivers.get(j+1));
//                        drivers.set(j+1,temp);
//                    }
//                }
//            }
//        }


//******************************************************************************************************************
//-------------------------------------------------Unnecessary------------------------------------------------------
//        for (int i=1; i<drivers.size()-1; i++) {
//            for (int j=2; j<drivers.size()-i-1; j++){
//                if (drivers.get(i).getPoints() == drivers.get(i).getPoints()){
//                    if (drivers.get(i).getFirstPositionCount() < drivers.get(i).getFirstPositionCount()){
//                        Formula1Driver temp = drivers.get(i);//temp = i
//                        drivers.set(i, drivers.get(j));//drivers[i] = drivers[j]
//                        drivers.set(j,temp);//drivers[j] = temp
//                    }
//                }
//            }
//            for (Formula1Driver driver : drivers) {
//                driver.getPoints().
//            }
//        }
// ******************************************************************************************************************
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

    //get the index of a driver
    public int getDriverIndex(String team) {
        int index;

        for (Formula1Driver driver : drivers) {
            if (team.equalsIgnoreCase(driver.getTeam())) {
                index = drivers.indexOf(driver);
                return index;
            }
        }
        return -1;
    }
}
