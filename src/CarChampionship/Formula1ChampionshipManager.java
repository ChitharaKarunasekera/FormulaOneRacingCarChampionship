package CarChampionship;

import javax.xml.crypto.Data;
import java.util.Collections;
import java.util.ArrayList;
import java.util.Scanner;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Formula1ChampionshipManager implements ChampionshipManager {
    Scanner input = new Scanner(System.in);

    ArrayList<Formula1Driver> drivers = new ArrayList<Formula1Driver>();//All divers participating in championship

    @Override
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

    //Overloaded driver method to restore drivers from saved data
    public void addNewDriver(String name, String location, String team, int firstPositionCount, int secondPositionCount, int thirdPositionCount, int points, int racesCount) {
        drivers.add(new Formula1Driver(name, location, team, firstPositionCount, secondPositionCount, thirdPositionCount, points, racesCount));//create new Formula1Driver object and add to array list
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

        //System.out.println("|  Driver Name  |  Team Name  |  1st positions  |  2nd positions  |  3rd positions  |  Total points  |  Completed Races  |\n");

        //Sort the drivers in Descending order of their points
        Collections.sort(drivers);

        String leftAlignFormat = "| %-11s | %-12s | %-13d | %-13d | %-13d | %-12d | %-9d |%n";

        System.out.format("+-------------------------------------------------------------------------------------------------------+%n");
        System.out.format("|                                      Formula 1 Driver CarChampionship Table                           |%n");
        System.out.format("+-------------+--------------+---------------+---------------+---------------+--------------+-----------+%n");
        System.out.format("| Driver Name | Team Name    | 1st Positions | 2nd Positions | 3rd Positions | Total Points | Completed |%n");
        System.out.format("+-------------+--------------+---------------+---------------+---------------+--------------+-----------+%n");
        for (Formula1Driver driver : drivers) {
            System.out.format(leftAlignFormat, driver.getName(), driver.getTeam(), driver.getFirstPositionCount(), driver.getSecondPositionCount(), driver.getThirdPositionCount(), driver.getPoints(), driver.getRacesCount());
        }
        System.out.format("+-------------+--------------+---------------+---------------+---------------+--------------+-----------+%n");
    }

    @Override
    public void raceCompleted() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();

        System.out.println("\nRace Completed!\n");
        System.out.println("Date and time of Completion : " + formatter.format(now));


        for(Formula1Driver driver: drivers){
            driver.setCurrentPositions(drivers.size());//each driver gets a random position based on number of drivers registered to championship.
            driver.assigningPoints(driver.getCurrentPositions());//driver's points will be updated according to position
        }
    }

    @Override
    public void saveToFile() {
        //Creating file if not existing
        try{
            File dataFile = new File("D:\\IIT\\2021-2022 Level 5\\OOP\\Course Work\\FormulaOneRacingCarChampionship\\ProgramData.txt");//File location
            if (dataFile.createNewFile()) {
                System.out.println("File created: " + dataFile.getName());
            }
        }catch(IOException e){
            System.out.println("An error occurred. Could not create file!");
            e.printStackTrace();
        }

        //Writing data to file.
        try{

            FileWriter writer = new FileWriter("D:\\IIT\\2021-2022 Level 5\\OOP\\Course Work\\FormulaOneRacingCarChampionship\\ProgramData.txt");//File location

            for (Formula1Driver driver : drivers) {
                writer.write(driver.getName() +
                        " "  + driver.getLocation() +
                        " "  + driver.getTeam() +
                        " "  + driver.getFirstPositionCount() +
                        " " + driver.getSecondPositionCount()  +
                        " " + driver.getThirdPositionCount() +
                        " " + driver.getPoints() +
                        " " + driver.getRacesCount()
                );
                writer.write("\n");
            }
            writer.close();
            System.out.println("\nSuccessfully uploaded data to file.");
        }catch(IOException e){
            System.out.println("An error occurred. Could not upload data to file!");
            e.printStackTrace();
        }
    }

    @Override
    public void readFromFile() {
        //Load data from file
        try{
            File data = new File("D:\\IIT\\2021-2022 Level 5\\OOP\\Course Work\\FormulaOneRacingCarChampionship\\ProgramData.txt");//File location
            Scanner reader = new Scanner(data);
            while(reader.hasNextLine())
            {
                String line = reader.nextLine();
                String[] driverData = line.trim().split("\\s+");//split each set of characters till a space is found

                String name = driverData[0];
                String location = driverData[1];
                String team = driverData[2];
                int firstPositionCount = Integer.parseInt(driverData[3]);
                int secondPositionCount = Integer.parseInt(driverData[4]);
                int thirdPositionCount = Integer.parseInt(driverData[5]);
                int points = Integer.parseInt(driverData[6]);
                int racesCount = Integer.parseInt(driverData[7]);

                addNewDriver(name, location, team, firstPositionCount, secondPositionCount, thirdPositionCount, points, racesCount);//pass all the info saved in each line to overloaded constructor

            }
            reader.close();
        }catch(IOException e){
            System.out.println("An error occurred. Could not load precious data!");
            e.printStackTrace();
        }
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
