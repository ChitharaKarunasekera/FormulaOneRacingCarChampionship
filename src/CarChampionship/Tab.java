package CarChampionship;

import javax.swing.*;
import java.awt.*;

public class Tab extends JFrame {
    JFrame myFrame;

    public Tab() {
        setLayout(new FlowLayout());

        //column names of table
        String[] columnNames = {"Driver Name", "Team Name", "1st Positions", "2nd Positions", "3rd Positions", "Points", "Completed"};

        //int driversLength = Formula1ChampionshipManager.drivers.size();//accessing the drivers array in Formula1ChampionshipManager

        Object[][] driverStats = new Object[5][7];

//        for (Formula1Driver driver : Formula1ChampionshipManager.drivers) {
        for (int i = 0; i < 5; i++) {
            driverStats[i][0] = 0;//driver.getName();
            driverStats[i][1] = 0;//driver.getTeam();
            driverStats[i][2] = 0;//driver.getFirstPositionCount();
            driverStats[i][3] = 0;//driver.getSecondPositionCount();
            driverStats[i][4] = 0;//driver.getThirdPositionCount();
            driverStats[i][5] = 0;//driver.getPoints();
            driverStats[i][6] = 0;//driver.getRacesCount();
        }
//        }


//        Object[][] data = {
//                {"Bill", "Hazel", "Male", "Male", "Male", "Male", 0},
//                {"Mary", "Black", "Female", "Male", "Male", "Male", 0},
//                {"Rick", "Red", "Male", "Male", "Male", "Male", 0},
//                {"Janice", "Yellow", "Female", "Male", "Male", "Male", 0},
//        };

        JTable table = new JTable(driverStats, columnNames);// creating table with column names and its data
        table.setPreferredScrollableViewportSize(new Dimension(600, 150));//width and height of table
        table.setFillsViewportHeight(true);

        //scroll pane
        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane);//table is inside scroll pane
    }
}
