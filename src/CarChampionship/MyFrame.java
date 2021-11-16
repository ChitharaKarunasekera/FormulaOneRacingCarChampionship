package CarChampionship;

import javax.swing.*;
import java.awt.*;

public class MyFrame extends JFrame{
    JButton button;
    JLabel label;

    public MyFrame(){
        this.setTitle("Formula 1 Car Racing Championship");//title of frame
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);// Frame cannot be re-sized
        this.setSize(800, 700);
        this.setVisible(true);// make frame visible

        ImageIcon image = new ImageIcon("images/CompanyName.png");//create an image icon for frame icon
        this.setIconImage(image.getImage());//change icon of frame
        this.getContentPane().setBackground(new Color(63, 63, 63));//background color of frame

        JPanel menuPanel = new JPanel();
        menuPanel.setBackground(Color.red);
        menuPanel.setBounds(0,0,250,800);
        menuPanel.setVisible(true);

        button = new JButton();
        button.setBounds(10,100,100,30);//dimensions of button
        button.setText("I'm a button");
        button.setVisible(true);


        this.add(menuPanel);
        menuPanel.add(button);

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
    }



}
