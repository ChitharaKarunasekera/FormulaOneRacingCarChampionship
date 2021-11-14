package CarChampionship;

import javax.swing.*;
import java.awt.*;

public class MyFrame{
    Tab myTable = new Tab();

    public MyFrame(){
//        //default frame
//        setLayout(new FlowLayout());
//
//        this.setTitle("Formula 1 Car Racing Championship");
//        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        //this.setResizable(false);
//        this.setSize(600,420);
//        this.setVisible(true);// make table visible
//
//        ImageIcon image = new ImageIcon("images/CompanyName.png");//create an image icon
//        this.setIconImage(image.getImage());//change icon of frame
//        this.getContentPane().setBackground(new Color(63, 63, 63));//background color of frame
//
//        String[] columnNames = {"Name", "Eye Color", "Gender"};
//        Object[][] data = {
//                {"Bill", "Hazel", "Male"},
//                {"Mary", "Black", "Female"},
//                {"Rick", "Red", "Male"},
//                {"Janice", "Yellow", "Female"},
//        };
//
//        driverTable = new JTable(data, columnNames);
//
//        driverTable = new JTable(data, columnNames);
//        driverTable.setPreferredScrollableViewportSize(new Dimension(500, 100));//width and height of table
//        driverTable.isEditing();
//
//        JScrollPane scrollPane = new JScrollPane(driverTable);
//        add(scrollPane);//table is inside scroll pane

        ImageIcon image = new ImageIcon("images/CompanyName.png");//create an image icon for frame icon

        myTable = new Tab();

        myTable.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myTable.setSize(650, 200);
        myTable.setVisible(true);// make frame visible
        myTable.setTitle("Formula 1 Car Racing Championship");//title of frame
        myTable.setResizable(false);// Frame cannot be re-sized

        myTable.setIconImage(image.getImage());//change icon of frame
        myTable.getContentPane().setBackground(new Color(63, 63, 63));//background color of frame
    }

}
