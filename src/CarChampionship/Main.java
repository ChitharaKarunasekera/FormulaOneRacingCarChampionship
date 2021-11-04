package CarChampionship;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        ChampionshipManager championship = new Formula1ChampionshipManager();//The championship race

        String choice;
        String comfirm;

        while (true) {
            System.out.println("\n==========Menu==========\n" +
                    "A - Add new driver\n" +
                    "D - Delete Driver\n" +
                    "Q - Quit");

            System.out.print("\nSelect you choice : ");
            choice = input.next();

            if (choice.equalsIgnoreCase("A")) {
                System.out.println("\nYou can add a driver!");

                championship.addNewDriver();//call the method to add a driver to the championship
                System.out.println("\nDriver was added to the championship competition!\n");

//                System.out.println("Name: " + championship.drivers.get(0).getName());
//                System.out.println("Location: " + championship.drivers.get(0).getLocation());
//                System.out.println("Team: " + championship.drivers.get(0).getTeam());
            }
            else if (choice.equalsIgnoreCase("D")){
                System.out.println("\nYou can delete a driver");
                championship.deleteDriver();
            }
            else if (choice.equalsIgnoreCase("Q")){
                //Confirm users input
                System.out.print("Are you sure you want to terminate the system (Y/N)?");
                comfirm = input.next();
                //quit program if user is sure
                if (comfirm.equalsIgnoreCase("Y")){
                    System.out.println("System terminated.");
                    break;
                }
            }
        }
//        Driver d1 = new Formula1Driver("Chithara", "Nugegoda", "TaemChithzz");
//
//        System.out.println("Name of d1: " + d1.getName());
//        System.out.println("Location : " + d1.getLocation());
//        System.out.println("Team : " + d1.getTeam());
//        d1.assigningPoints(11);
//        d1.assigningPoints(2);
//        System.out.println("Points: " + d1.getPoints());
//        System.out.println("First Poss Count: " + d1.getFirstPositionCount());
    }

}
