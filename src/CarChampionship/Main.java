package CarChampionship;

public class Main {

    public static void main(String[] args) {
        Driver d1 = new Formula1Driver("Chithara", "Nugegoda", "TaemChithzz");

        System.out.println("Name of d1: " + d1.getName());
        System.out.println("Location : " + d1.getLocation());
        System.out.println("Team : " + d1.getTeam());
        d1.assigningPoints(11);
        d1.assigningPoints(2);
        System.out.println("Points: " + d1.getPoints());
        System.out.println("First Poss Count: " + d1.getFirstPositionCount());
    }
}
