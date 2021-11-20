package CarChampionship;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class DriverStatsFrame implements ActionListener {
    JFrame tableFrame = new JFrame("Formula 1 Car Racing Championship");
    JLabel label = new JLabel("Statistics of Drivers");
    JButton backBtn = new JButton("Back to Main Menu");
    JTable table;

    ArrayList<Formula1Driver> driverList = new ArrayList<>();

    public DriverStatsFrame(ArrayList<Formula1Driver> drivers){
        this.driverList = drivers;

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
        label.setBounds(0,0,800,50);
        label.setFont(new Font("Century Gothic",Font.PLAIN, 25));
        label.setForeground(new Color(166, 166, 166));
        northPanel.add(label);

        //adding back button in button panel
        backBtn.setBounds(0,25,400,50);
        backBtn.setFont(new Font("Century Gothic",Font.PLAIN, 18));
        backBtn.setFocusable(false);//remove broader around text
        backBtn.setForeground(new Color(62, 62, 62));
        backBtn.setBackground(new Color(166, 166, 166));
        backBtn.addActionListener(this);
        southPanel.add(backBtn, BorderLayout.CENTER);

        //Table
        String[] columnNames = {"Driver Name", "Team Name", "1st Positions", "2nd Positions", "3rd Positions", "Points", "Completed"};
//        Object[][] data = {
//                {"Bill", "Hazel", "Male", "Male", "Male", "Male", "Male"},
//                {"Mary", "Black", "Female", "Male", "Male", "Male", "Male"},
//                {"Rick", "Red", "Male", "Male", "Male", "Male", "Male"},
//                {"Janice", "Yellow", "Female", "Male", "Male", "Male", "Male"},
//        };
        Object[][] data = new Object[drivers.size()][7];

//        for (Formula1Driver driver: drivers){
//            int i=0;
//            data[i][0] = driver.getName();
//            data[i][1] = driver.getTeam();
//            data[i][2] = driver.getFirstPositionCount();
//            data[i][3] = driver.getSecondPositionCount();
//            data[i][4] = driver.getThirdPositionCount();
//            data[i][5] = driver.getPoints();
//            data[i][6] = driver.getRacesCount();
//            ++i;
//        }

        for (int i=0; i<driverList.size(); i++){
            data[i][0] = driverList.get(i).getName();
            data[i][1] = driverList.get(i).getTeam();
            data[i][2] = driverList.get(i).getFirstPositionCount();
            data[i][3] = driverList.get(i).getSecondPositionCount();
            data[i][4] = driverList.get(i).getThirdPositionCount();
            data[i][5] = driverList.get(i).getPoints();
            data[i][6] = driverList.get(i).getRacesCount();
        }

        table = new JTable(data, columnNames);
        table.setPreferredScrollableViewportSize(new Dimension(750, 100));//width and height of table
        table.isEditing();

        //scroll pane
        JScrollPane scrollPane = new JScrollPane(table);//interest table into scroll pane
        centerPanel.add(scrollPane);//table is inside scroll pane

        tableFrame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == backBtn){
            tableFrame.dispose();//close current frame
            MenuFrame menu = new MenuFrame(driverList);
        }
    }
}
