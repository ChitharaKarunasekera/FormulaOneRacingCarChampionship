/*
References
Horstmann, C., 2021. INPUT/OUTPUT AND EXCEPTION HANDLING.
Horstmann, C., 2021. INTERFACES.
tables?, A., Valenty, M. and Kongslund, J., 2021. Any Java libraries for drawing ASCII tables?. [online] Stack Overflow. Available at: <https://stackoverflow.com/questions/5608588/any-java-libraries-for-drawing-ascii-tables> [Accessed 10 November 2021].
Youtube.com. 2021. [online] Available at: <https://www.youtube.com/watch?v=-xW0pBZqpjU> [Accessed 15 November 2021].
Youtube.com. 2021. [online] Available at: <https://www.youtube.com/watch?v=Kmgo00avvEw> [Accessed 17 November 2021].
*/

package CarChampionship;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        Formula1ChampionshipManager championship = new Formula1ChampionshipManager();//New formula 1 championship race

        String choice;
        String confirm;

        //start GUI
        MenuFrame frame = new MenuFrame(championship);

        while (true) {
            System.out.println("\n==========Menu==========\n" +
                    "A - Add new driver\n" +
                    "D - Delete Driver\n" +
                    "C - Change team \n" +
                    "V - View drive's statistics\n" +
                    "T - Display the Formula 1 Driver CarChampionship.Table\n" +
                    "R - Complete Race and Show Statistics\n" +
                    "S - Upload data to file\n" +
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
                System.out.println("\nFormula 1 Driver CarChampionship.Table.");
                championship.displayAllDrivers();
            }
            else if (choice.equalsIgnoreCase("R")){
                championship.insertRace();
            }
            else if (choice.equalsIgnoreCase("S")){
                championship.saveToFile();
            }
            else if (choice.equalsIgnoreCase("L")){
                championship.readFromFile();
            }
            else if (choice.equalsIgnoreCase("Q")){
                //Confirm users input
                System.out.print("Are you sure you want to terminate the system (Y/N)?");
                confirm = input.next();
                //quit program if user is sure
                if (confirm.equalsIgnoreCase("Y")){
                    championship.saveToFile();
                    System.out.println("System terminated. Your data was automatically saved.");
                    break;
                }
            }
            else {
                System.out.println("Option not found!");
            }
        }


    }

}
