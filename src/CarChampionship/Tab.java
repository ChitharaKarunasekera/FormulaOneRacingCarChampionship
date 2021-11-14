package CarChampionship;

import javax.swing.*;
import java.awt.*;

public class Tab extends JFrame {
    JTable table;

    public Tab(){
        setLayout(new FlowLayout());

        //column names of table
        String[] columnNames = {"Driver Name", "Team Name", "1st Positions", "2nd Positions", "3rd Positions", "Points", "Completed"};


        Object[][] data = {
                {"Bill", "Hazel", "Male", "Male", "Male", "Male", "Male"},
                {"Mary", "Black", "Female", "Male", "Male", "Male", "Male"},
                {"Rick", "Red", "Male", "Male", "Male", "Male", "Male"},
                {"Janice", "Yellow", "Female", "Male", "Male", "Male", "Male"},
        };

        table = new JTable(data, columnNames);// creating table with column names and its data
        table.setPreferredScrollableViewportSize(new Dimension(600, 150));//width and height of table
        table.setFillsViewportHeight(true);

        //scroll pane
        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane);//table is inside scroll pane
    }
}
