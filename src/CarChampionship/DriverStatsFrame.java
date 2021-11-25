package CarChampionship;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class DriverStatsFrame implements ActionListener {
    JFrame tableFrame = new JFrame("Formula 1 Car Racing Championship");
    JLabel tblTitle = new JLabel("Statistics of Drivers");
    JButton backBtn = new JButton("Back to Main Menu");
    JTable table;

    Formula1ChampionshipManager championship;
    ArrayList<Formula1Driver> driverList;
    ArrayList<Race> races;

    public DriverStatsFrame(Formula1ChampionshipManager championship, ArrayList<Formula1Driver> driverList){
        this.championship = championship;
        this.driverList = driverList;
        this.races = championship.getRaces();

        tableFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        tableFrame.setSize(900, 700);
        tableFrame.setLayout(new BorderLayout(0, 0));//add margin between components
        ImageIcon image = new ImageIcon("images/CompanyName.png");//create an image icon for frame icon
        tableFrame.setIconImage(image.getImage());//change icon of frame

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

        tableFrame.add(northPanel, BorderLayout.NORTH);
        tableFrame.add(westPanel, BorderLayout.WEST);
        tableFrame.add(eastPanel, BorderLayout.EAST);
        tableFrame.add(southPanel, BorderLayout.SOUTH);
        tableFrame.add(centerPanel, BorderLayout.CENTER);

        //adding label as topic in top panel
        tblTitle.setBounds(0,0,800,50);
        tblTitle.setFont(new Font("Century Gothic",Font.PLAIN, 25));
        tblTitle.setForeground(new Color(166, 166, 166));
        northPanel.add(tblTitle);

        //adding back button in button panel
        backBtn.setBounds(0,25,400,50);
        backBtn.setFont(new Font("Century Gothic",Font.PLAIN, 18));
        backBtn.setFocusable(false);//remove broader around text
        backBtn.setForeground(new Color(62, 62, 62));
        backBtn.setBackground(new Color(166, 166, 166));
        backBtn.addActionListener(this);
        southPanel.add(backBtn, BorderLayout.CENTER);

        //Table
        String[] columnNames = {"Driver Name", "Team Name", "1st Positions", "2nd Positions", "3rd Positions", "Points", "Completed", "Starting Position", "Current Position"};

        Object[][] data = new Object[championship.getDrivers().size()][9];


        for (int i=0; i<driverList.size(); i++){
            data[i][0] = driverList.get(i).getName();
            data[i][1] = driverList.get(i).getTeam();
            data[i][2] = driverList.get(i).getFirstPositionCount();
            data[i][3] = driverList.get(i).getSecondPositionCount();
            data[i][4] = driverList.get(i).getThirdPositionCount();
            data[i][5] = driverList.get(i).getPoints();
            data[i][6] = driverList.get(i).getRacesCount();
            data[i][7] = driverList.get(i).getStartingPosition();
            data[i][8] = driverList.get(i).getCurrentPositions();
        }

        table = new JTable(data, columnNames);
        table.setPreferredScrollableViewportSize(new Dimension(770, 400));//width and height of table
        table.isEditing();

        //scroll pane
        JScrollPane scrollPane = new JScrollPane(table);//interest table into scroll pane
        centerPanel.add(scrollPane);//table is inside scroll pane

        //adding label as topic in top panel
        JLabel raceNo = new JLabel("<html><p>Race Number : " + Race.raceNumber + "</p> <p>" + "Date and Time : " + races.get(races.size()-1).getDateTime() + "</p><html>");
        raceNo.setBounds(0,0,800,50);
        raceNo.setFont(new Font("Century Gothic",Font.PLAIN, 20));
        raceNo.setForeground(new Color(166, 166, 166));
        centerPanel.add(raceNo);

        tableFrame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == backBtn){
            tableFrame.dispose();//close current frame
            MenuFrame menu = new MenuFrame(championship);
        }
    }
}