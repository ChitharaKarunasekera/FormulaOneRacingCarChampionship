package CarChampionship;

import javax.swing.*;
import java.awt.*;

public class RaceStatsFrame {
    JFrame raceTableFrame = new JFrame("Formula 1 Car Racing Championship");
    JTable table;

    public RaceStatsFrame(){
        raceTableFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        raceTableFrame.setSize(900, 700);
        raceTableFrame.setLayout(new BorderLayout(0, 0));//add margin between components
        ImageIcon image = new ImageIcon("images/CompanyName.png");//create an image icon for frame icon
        raceTableFrame.setIconImage(image.getImage());//change icon of frame

        JPanel northPanel = new JPanel();
        JPanel westPanel = new JPanel();
        JPanel eastPanel = new JPanel();
        JPanel southPanel = new JPanel();
        JPanel centerPanel = new JPanel();

        northPanel.setBackground(new Color(72, 72, 73));
        westPanel.setBackground(new Color(72, 72, 73));
        eastPanel.setBackground(new Color(72, 72, 73));
        southPanel.setBackground(new Color(72, 72, 73));
        centerPanel.setBackground(new Color(62, 62, 62));

        northPanel.setPreferredSize(new Dimension(100, 50));
        westPanel.setPreferredSize(new Dimension(50, 100));
        eastPanel.setPreferredSize(new Dimension(50, 100));
        southPanel.setPreferredSize(new Dimension(100, 100));
        centerPanel.setPreferredSize(new Dimension(100, 100));

        raceTableFrame.add(northPanel, BorderLayout.NORTH);
        raceTableFrame.add(westPanel, BorderLayout.WEST);
        raceTableFrame.add(eastPanel, BorderLayout.EAST);
        raceTableFrame.add(southPanel, BorderLayout.SOUTH);
        raceTableFrame.add(centerPanel, BorderLayout.CENTER);

        //adding label as topic in top panel
        raceTableFrame.setBounds(0,0,800,50);
        raceTableFrame.setFont(new Font("Century Gothic",Font.PLAIN, 25));
        raceTableFrame.setForeground(new Color(166, 166, 166));




//        //Table
//        String[] columnNames = {"Driver Name", "Team Name", "1st Positions", "2nd Positions", "3rd Positions", "Points", "Completed", "Starting Position", "Current Position"};
//        Object[][] data = new Object[championship.getDrivers().size()][9];
//
//        for (int i=0; i<driverList.size(); i++){
//            data[i][0] = driverList.get(i).getName();
//            data[i][1] = driverList.get(i).getTeam();
//            data[i][2] = driverList.get(i).getFirstPositionCount();
//            data[i][3] = driverList.get(i).getSecondPositionCount();
//            data[i][4] = driverList.get(i).getThirdPositionCount();
//            data[i][5] = driverList.get(i).getPoints();
//            data[i][6] = driverList.get(i).getRacesCount();
//            data[i][7] = driverList.get(i).getStartingPosition();
//            data[i][8] = driverList.get(i).getCurrentPositions();
//        }

        table = new JTable(data, columnNames);
        table.setPreferredScrollableViewportSize(new Dimension(770, 400));//width and height of table
        table.isEditing();

        //scroll pane
        JScrollPane scrollPane = new JScrollPane(table);//interest table into scroll pane
        centerPanel.add(scrollPane);//table is inside scroll pane

        raceTableFrame.setVisible(true);
    }
}
