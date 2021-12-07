package CarChampionship;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class MenuFrame implements ActionListener {
    Random rand = new Random();//to generate a random number

    Formula1ChampionshipManager championship;
    ArrayList<Formula1Driver> driverList;
    ArrayList<Race> racesList;

    JFrame menuFrame = new JFrame("Formula 1 Car Racing Championship");
    JLabel menuLabel = new JLabel("Main Menu");

    JButton option1 = new JButton("Driver statistics in descending order of points");
    JButton option2 = new JButton("Driver statistics in ascending order of points");
    JButton option3 = new JButton("Drivers based on largest number of 1st positions");
    JButton option4 = new JButton("Generate race");
    JButton option5 = new JButton("Generate race with race statistics");
    JButton option6 = new JButton("Completed races");
    JButton option7 = new JButton("Option seven");

    JButton[] options = {option1, option2, option3, option4, option5, option6, option7};

    public MenuFrame(Formula1ChampionshipManager championship) {
        this.championship = championship;
        this.driverList = championship.getDrivers();
        this.racesList = championship.getRaces();

        menuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        menuFrame.setSize(900, 600);
        menuFrame.setLayout(new BorderLayout(0, 0));//add margin between components
        ImageIcon image = new ImageIcon("images/CompanyName.png");//create an image icon for frame icon
        menuFrame.setIconImage(image.getImage());//change icon of frame
        menuFrame.setLocationRelativeTo(null);//open frame in center of screen
        //menuFrame.getContentPane().setBackground(new Color(79, 79, 79));//background color of frame


        JPanel northPanel = new JPanel();
        JPanel westPanel = new JPanel();
        JPanel eastPanel = new JPanel();
        JPanel southPanel = new JPanel();
        JPanel centerPanel = new JPanel();

        northPanel.setBackground(new Color(72, 72, 73));
        westPanel.setBackground(new Color(72, 72, 73));
        eastPanel.setBackground(new Color(72, 72, 73));
        southPanel.setBackground(new Color(72, 72, 73));
        centerPanel.setBackground(new Color(72, 72, 73));

        northPanel.setPreferredSize(new Dimension(100, 50));
        westPanel.setPreferredSize(new Dimension(100, 100));
        eastPanel.setPreferredSize(new Dimension(100, 100));
        southPanel.setPreferredSize(new Dimension(100, 50));
        centerPanel.setPreferredSize(new Dimension(100, 100));

        //------------------------------------------SUB PANELS----------------------------------------------------
        JPanel centerNorth = new JPanel();
        JPanel centerWest = new JPanel();
        JPanel centerEast = new JPanel();
        JPanel centerSouth = new JPanel();
        JPanel centerCenter = new JPanel();

        centerNorth.setBackground(new Color(62, 62, 62));
        centerSouth.setBackground(new Color(62, 62, 62));
        centerWest.setBackground(new Color(62, 62, 62));
        centerEast.setBackground(new Color(62, 62, 62));
        centerCenter.setBackground(new Color(62, 62, 62));

        centerPanel.setLayout(new BorderLayout());

        centerNorth.setPreferredSize(new Dimension(25, 25));
        centerSouth.setPreferredSize(new Dimension(25, 25));
        centerWest.setPreferredSize(new Dimension(25, 25));
        centerEast.setPreferredSize(new Dimension(25, 25));
        centerCenter.setPreferredSize(new Dimension(25, 25));

        centerPanel.add(centerNorth, BorderLayout.NORTH);
        centerPanel.add(centerSouth, BorderLayout.SOUTH);
        centerPanel.add(centerWest, BorderLayout.WEST);
        centerPanel.add(centerEast, BorderLayout.EAST);
        centerPanel.add(centerCenter, BorderLayout.CENTER);
        //------------------------------------------SUB PANELS----------------------------------------------------

        menuFrame.add(northPanel, BorderLayout.NORTH);
        menuFrame.add(westPanel, BorderLayout.WEST);
        menuFrame.add(eastPanel, BorderLayout.EAST);
        menuFrame.add(southPanel, BorderLayout.SOUTH);
        menuFrame.add(centerPanel, BorderLayout.CENTER);

        menuLabel.setBounds(0, 0, 300, 50);
        menuLabel.setFont(new Font("Century Gothic", Font.PLAIN, 25));
        menuLabel.setForeground(new Color(166, 166, 166));
        northPanel.add(menuLabel);

        centerCenter.setLayout(new GridLayout(7, 1, 10, 10));

        for (JButton option : options) {
            option.setFocusable(false);//remove broader around text
            option.setFont(new Font("Century Gothic", Font.PLAIN, 20));
            option.setForeground(new Color(62, 62, 62));
            option.setBackground(new Color(166, 166, 166));
            centerCenter.add(option);
            option.addActionListener(this);
        }

        menuFrame.setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == option1) {
            menuFrame.dispose();//dispose current frame
            Collections.sort(driverList);//sort drivers in ascending order of points
            DriverStatsFrame tableWindow = new DriverStatsFrame(championship);//open new driver table frame

        }
        else if (e.getSource() == option2) {
            menuFrame.dispose();
            Collections.reverse(driverList);//sort drivers in descending order of points
            DriverStatsFrame tableWindow = new DriverStatsFrame(championship);
            Collections.sort(driverList);//arrange array back in ascending order of points
        }
//        //****************************** option 3 to be added *****************************
        else if (e.getSource() == option4) {
            menuFrame.dispose();//dispose current frame
            championship.clearDriverPos();//clear driver start positions if given
            championship.generateRace();//auto generate a race and assign random positions for drivers
            Collections.sort(driverList);
            DriverStatsFrame tableWindow = new DriverStatsFrame(championship);
            //********************* can be no 1st position, or can be a 6th pos without a 5th ********************
        } else if (e.getSource() == option5) {
            menuFrame.dispose();//dispose current frame

            championship.clearDriverPos();//clear current start positions

            //generate random start positions for each driver without position repetition
            for (Formula1Driver driver : driverList) {
                int position = rand.nextInt(driverList.size()) + 1;
                //driver.setStartingPosition(driverList.size());//set a random start position for driver
                while (championship.isPositionGiven(position)) {
                    //driver.setStartingPosition(driverList.size());//if the position was already assigned, then set a new position
                    position = rand.nextInt(driverList.size()) + 1;
                    System.out.println(driver.getStartingPosition());
                }
                driver.setStartingPosition(position);
                System.out.println("Driver Pos: " + driver.getStartingPosition());
            }

            championship.generateRace();
            Collections.sort(driverList);
            DriverStatsFrame tableWindow = new DriverStatsFrame(championship);
        } else if (e.getSource() == option6) {
            menuFrame.dispose();//dispose current frame
            championship.clearDriverPos();//clear current start positions

            System.out.println("RAces Frame");
            RacesFrame competedRaces = new RacesFrame(championship);
        }
    }
}

