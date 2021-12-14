package CarChampionship;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;


public class Formula1ChampionshipManager implements ChampionshipManager {
    private Scanner input = new Scanner(System.in);
    private boolean loadStatus = false;
    private final String fileName = "Data";

    private ArrayList<Formula1Driver> drivers = new ArrayList<Formula1Driver>();//All divers participating in championship
    private ArrayList<Race> races = new ArrayList<>();//All races held in championship

    private static int totalDrivers = 0;

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

        ++totalDrivers;//increase driver count by one

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
                if (driver.getTeam().equalsIgnoreCase(team)) {
                    System.out.print("Driver was found. Are you sure you want to delete driver " + driver.getName() + "(Y/N)? ");
                    confirm = input.next();
                    if (confirm.equalsIgnoreCase("Y")) {
                        String name = driver.getName();
                        drivers.remove(driver);//access the index of particular driver and set it to null;
                        System.out.println("Driver " + name + " was successfully deleted!");
                        break;
                    } else {
                        System.out.println("Process cancelled! Driver was not removed.");
                    }
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

    //Method to validate user inserted date
    public Date validateDate() throws ParseException {
        boolean valid;

        String date;
        int year;
        int month;
        int day;

        while (true) {
            while (true) {
                valid = true;

                //input date from user
                System.out.print("Enter date (Format: yyyy/mm/dd): ");
                date = input.next();

                //check if the inserted date has year, month, day correctly
                if (date.length() == 10) {
                    year = Integer.parseInt(date.substring(0, 4));
                    month = Integer.parseInt(date.substring(5, 7));
                    day = Integer.parseInt(date.substring(8));

                    //Check if the date has not passed current year
                    if (year > 2023) {
                        System.out.println("Invalid year");
                        valid = false;
                    }
                    //Check if month is valid
                    if (month < 1 || month > 12) {
                        System.out.println("Invalid month");
                        valid = false;
                    }
                    //Check if the day is valid
                    if (day < 1 || day > 31) {
                        System.out.println("Invalid day");
                        valid = false;
                    }

                    //If inserted date is valid, convert it as one String in required format
                    if (valid) {
                        String dateTime = year + "/" + month + "/" + day;
                        Date validDate = new SimpleDateFormat("yyyy/MM/dd").parse(dateTime);//convert String value to Date type and return
                        return validDate;
                    } else {
                        System.out.println("\nInvalid date, Please re-enter Date!");//inserted date is not valid.
                    }
                    break;
                } else {
                    System.out.println("\nInserted Date too short!");//inserted date is too short
                }
            }
        }
    }

    @Override
    public void insertRace() throws ParseException {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();

        String choice;
        String team;
        int position;
        ArrayList<Formula1Driver> participants = new ArrayList<>();//this array contains the drivers who will be participating in race

        //Collect driver statistics
        while (true) {
            System.out.print("\nEnter driver's statistics (Y/N)?");
            choice = input.next();

            if (choice.equalsIgnoreCase("Y")) {
                System.out.print("Enter team name: ");
                team = input.next();

                //Get and assign points to driver if team exists, and assign points accordingly
                if (isTeamExisting(team)) {
                    System.out.print("Enter position won: ");
                    if (input.hasNextInt()) {
                        position = input.nextInt();
                        drivers.get(getDriverIndex(team)).setCurrentPosition(position);
                        drivers.get(getDriverIndex(team)).assigningPoints(position);
                        participants.add(drivers.get(getDriverIndex(team)));//add the driver to participants array
                    } else {
                        System.out.println("\nDriver was not added! Please enter an Integer!");
                        input.next();//Remove the existing data of Scanner to get another input to it
                    }

                } else {
                    System.out.println("Sorry, team not found!");//inform user that team was not found
                }
            } else {
                break;
            }
        }

        if (participants.size() > 0) {
            races.add(new Race(validateDate(), participants.size(), participants));//adding race to races list
            Race race = races.get(races.size() - 1);//Access last added race, which is this race
            race.setRaceId(races.size());//set the ID of that race as the count of races
            race.setAutomatic(false);//mark race type as Manually generated race
            System.out.println("\nRace inserted successfully!");
            String dateTime = races.get(races.size() - 1).getDate();
            String date = dateTime.substring(0, 10);
            System.out.println("Date : " + date);
            System.out.println("Number of drivers participated: " + participants.size());
            System.out.println("Race ID: " + (races.get(races.size() - 1).getRaceId()));//get the race id

            for (Formula1Driver driver : participants) {
                driver.setRacesParticipated(races.get(races.size() - 1).getRaceId());//mark the race id for every driver participated
            }
        } else {
            System.out.println("No drivers have participated. Race was not inserted!");
        }
    }

    public void generateRace() throws ParseException {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDateTime now = LocalDateTime.now();
        Random rand = new Random();

        for (Formula1Driver driver : drivers) {
            //if a driver gets win, then driver gets 1st position
            //driver's points will be updated according to position
            if (driver.isWin()) {
                driver.setCurrentPosition(1);
            } else {
                int position = rand.nextInt(drivers.size()) + 1;
                driver.setCurrentPosition(position);//each driver gets a random position based on number of drivers registered to championship.
            }
            driver.assigningPoints(driver.getCurrentPositions());//driver's points will be updated according to position
        }

        System.out.println("\nRace Completed!\n");
        System.out.println("Date and time of Completion : " + formatter.format(now));
        System.out.println(totalDrivers + " Drivers participated in race.");

        //Auto generate date ane convert it to Date type to pass it to Race constructor
        races.add(new Race(new SimpleDateFormat("yyyy/MM/dd").parse(String.valueOf(formatter.format(now))), drivers.size(), drivers));//add a race to array and pass current time and total drivers participated
        Race race = races.get(races.size() - 1);
        race.setRaceId(races.size());//set the ID of that race as the count of races
        race.setAutomatic(true);//mark race type as Automatically generated race

        for (Formula1Driver driver : drivers) {
            driver.setRacesParticipated(races.get(races.size() - 1).getRaceId());//mark the race id for every driver participated
        }
    }

    public void positionBasedWinning() {
        Random rand = new Random();
        double prob;

        for (Formula1Driver driver : drivers) {
            prob = rand.nextDouble();

            //Based on each driver's start position, driver winning the race is decided on a probability according to position
            switch (driver.getStartingPosition()) {
                //if start position is 1 the driver has 40% probability to win race
                case 1:
                    if (prob < 0.4) {
                        driver.setWin(true);
                    }
                    break;
                //if start position is 2 the driver has 30% probability to win race
                case 2:
                    if (prob < 0.3) {
                        driver.setWin(true);
                    }
                    break;
                //if start position is 3 or 4 the driver has 10% probability to win race
                case 3:
                case 4:
                    if (prob < 0.1) {
                        driver.setWin(true);
                    }
                    break;
                //if start position is between 5 - 9 the driver has 2% probability to win race
                case 5:
                case 6:
                case 7:
                case 8:
                case 9:
                    if (prob < 0.02) {
                        driver.setWin(true);
                    }
                    break;
                //Other drivers have no probability to win
                default:
                    driver.setWin(false);
            }
            if (driver.getStartingPosition() == 1) {
                if (prob < 0.4) {
                    driver.setWin(true);
                }
            }
        }
    }

    @Override
    public void saveToFile() {
        SaveData saveData = new SaveData();
        saveData.drivers = this.drivers; //assign the drivers array to the SaveData class array
        saveData.races = this.races; //assign the races array to the SaveData class array

        try {
            ResourceManager.save(saveData, fileName);
            System.out.println("Successfully stored data to file");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Sorry, Could not store to file");
        }
    }

    @Override
    public void readFromFile() {
        try {
            SaveData saveData = (SaveData) ResourceManager.load(fileName);
            //get the arrays of SaveData class
            this.drivers.addAll(saveData.drivers);//add all drivers in save data array to existing driver array
            this.races.addAll(saveData.races);//add all races in save data array to existing races array
            System.out.println("Successfully loaded data to program");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Sorry, Could not load data to program");
        }
    }


    //sort the drivers array based on the 1st positions won in descending order
    Comparator<Formula1Driver> comparator = new Comparator<Formula1Driver>() {
        @Override
        public int compare(Formula1Driver o1, Formula1Driver o2) {
            if (o1.getFirstPositionCount() > o2.getFirstPositionCount()) {
                return -1;
            } else if (o1.getFirstPositionCount() < o2.getFirstPositionCount()) {
                return 1;
            } else {
                return 0;
            }
        }
    };

    //sort the races array based on the 1st dates in acceding order
    Comparator<Race> comparatorDate = new Comparator<Race>() {

        @Override
        public int compare(Race o1, Race o2) {
            if (o1.getDate().compareTo(o2.getDate()) < 0) {
                return -1;
            } else if (o1.getDate().compareTo(o2.getDate()) > 0) {
                return 1;
            } else {
                return 0;
            }
        }
    };

    public boolean isTeamExisting(String team) {
        for (Formula1Driver driver : drivers) {
            if (team.equalsIgnoreCase(driver.getTeam())) {
                return true;//return true if team name was found
            }
        }
        return false;//team name not found
    }

    public boolean isPositionGiven(int position) {
        for (Formula1Driver driver : drivers) {
            if (position == driver.getStartingPosition()) {
                return true;//return true if position was given
            }
        }
        return false;//position was not given
    }

    public void clearDriverPos() {
        for (Formula1Driver driver : drivers) {
            driver.setStartingPosition(0);
        }
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

    public ArrayList<Formula1Driver> getDrivers() {
        return drivers;
    }

    public ArrayList<Race> getRaces() {
        return races;
    }
}