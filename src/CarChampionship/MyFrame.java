package CarChampionship;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyFrame extends JFrame{
//    JButton button;
//    JLabel label;
static int a = 0;
JTable driverTable;

    public MyFrame() {
        this.setTitle("Formula 1 Car Racing Championship");
        this.setSize(600,420);

        JButton colorBtn = new JButton("Color");
        colorBtn.setBounds(200, 100, 150, 50);

        ImageIcon image = new ImageIcon("images/CompanyName.png");//create an image icon for frame icon
        this.setIconImage(image.getImage());//change icon of frame

        colorBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (a % 2 == 0) {
                    getContentPane().setBackground(Color.CYAN);
                    a++;
                } else {
                    getContentPane().setBackground(Color.green);
                    a++;
                }
            }
        });

        String[] columnNames = {"Driver Name", "Team Name", "1st Positions", "2nd Positions", "3rd Positions", "Points", "Completed"};
        Object[][] data = new Object[5][];

        driverTable = new JTable(data, columnNames);

        driverTable = new JTable(data, columnNames);
        driverTable.setPreferredScrollableViewportSize(new Dimension(500, 100));//width and height of table


        this.add(colorBtn);
        this.setSize(500, 500);
        this.setLayout(null);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.add(driverTable);


//        this.setTitle("Formula 1 Car Racing Championship");//title of frame
//        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        this.setResizable(false);// Frame cannot be re-sized
//        this.setSize(800, 700);
//        this.setVisible(true);// make frame visible
//
//        ImageIcon image = new ImageIcon("images/CompanyName.png");//create an image icon for frame icon
//        this.setIconImage(image.getImage());//change icon of frame
//        this.getContentPane().setBackground(new Color(63, 63, 63));//background color of frame
//
//
//
//
//        button = new JButton();
//        button.setBounds(150,100,250,50);//dimensions of button
//        button.setText("I'm a button");
//        button.setFocusable(false);//remove broader around text
//        //button.setIcon(icon);
//        button.setHorizontalTextPosition(JButton.CENTER);
//        button.setVerticalTextPosition(JButton.BOTTOM);
//        button.setFont(new Font("Comic Sans", Font.PLAIN,14));
//        //button.setIconTextGap(0);
//        button.setForeground(Color.red);
//        button.setBackground(Color.lightGray);
//        button.setBorder(BorderFactory.createEtchedBorder());
////
////
//        this.add(button);


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
