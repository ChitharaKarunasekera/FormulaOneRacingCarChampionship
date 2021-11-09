package CarChampionship;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        ChampionshipManager championship = new Formula1ChampionshipManager();//The championship race
        //Comparator<Formula1Driver> comparator = new Formula1ChampionshipManager();

        String choice;
        String confirm;

        while (true) {
            System.out.println("\n==========Menu==========\n" +
                    "A - Add new driver\n" +
                    "D - Delete Driver\n" +
                    "C - Change team \n" +
                    "V - View drive's statistics\n" +
                    "T - Display the Formula 1 Driver Table\n" +
                    "S - Complete Race and Show Statistics\n" +
                    "U - Upload data to file\n" +
                    "L - Load data from file\n" +
                    "Q - Quit");

            System.out.print("\nSelect you choice : ");
            choice = input.next();

            if (choice.equalsIgnoreCase("A")) {
                System.out.println("\nYou can add a driver!");
                championship.addNewDriver();//call the method to add a driver to the championship
            }
            else if (choice.equalsIgnoreCase("D")){
                System.out.println("\nYou can delete a driver.");
                championship.deleteDriver();
            }
            else if (choice.equalsIgnoreCase("C")){
                System.out.println("\nYou can delete a driver.");
                championship.changeTeam();
            }else if (choice.equalsIgnoreCase("V")){
                System.out.println("\nYou can view driver's statistics.");
                championship.displayStatistics();
            }
            else if (choice.equalsIgnoreCase("T")){
                System.out.println("\nFormula 1 Driver Table.");
                championship.displayAllDrivers();
            }
            else if (choice.equalsIgnoreCase("S")){
                championship.raceCompleted();
            }
            else if (choice.equalsIgnoreCase("Q")){
                //Confirm users input
                System.out.print("Are you sure you want to terminate the system (Y/N)?");
                confirm = input.next();
                //quit program if user is sure
                if (confirm.equalsIgnoreCase("Y")){
                    System.out.println("System terminated.");
                    break;
                }
            }
            else {
                System.out.println("Option not found!");
            }
        }
    }

}
