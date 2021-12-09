package CarChampionship;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class SearchRaceFrame implements ActionListener {
    int number = 1;
    JFrame search = new JFrame("Formula 1 Car Racing Championship");
    JLabel menuLabel = new JLabel("Completed Races");
    JButton backBtn = new JButton("Back to Main Menu");
    JTextField driverField = new JTextField();//adding text field
    JButton searchBtn = new JButton("Search");
    JPanel racePanel = new JPanel();
    JLabel inform = new JLabel();
    JPanel centerSubCenter;

    Formula1ChampionshipManager championship;
    ArrayList<Race> racesList;
    ArrayList<Formula1Driver> driverList;

    JTable table;

    String driverName;

    //Border border = BorderFactory.createLineBorder(Color.BLUE, 1);

    public SearchRaceFrame(Formula1ChampionshipManager championship) {
        this.championship = championship;
        this.racesList = championship.getRaces();//races list from championship class
        this.driverList = championship.getDrivers();//drivers list from championship

        search.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        search.setSize(700, 700);
        search.setLayout(new BorderLayout(0, 0));//add margin between components
        ImageIcon image = new ImageIcon("images/CompanyName.png");//create an image icon for frame icon
        search.setIconImage(image.getImage());//change icon of frame
        //menuFrame.getContentPane().setBackground(new Color(79, 79, 79));//background color of frame
        search.setLocationRelativeTo(null);//open frame in center of screen


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
        westPanel.setPreferredSize(new Dimension(50, 100));
        eastPanel.setPreferredSize(new Dimension(50, 100));
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
        centerCenter.setBackground(new Color(166, 166, 166));

        centerPanel.setLayout(new BorderLayout());

        centerNorth.setPreferredSize(new Dimension(25, 25));
        centerSouth.setPreferredSize(new Dimension(25, 25));
        centerWest.setPreferredSize(new Dimension(35, 25));
        centerEast.setPreferredSize(new Dimension(35, 25));
        centerCenter.setPreferredSize(new Dimension(25, 25));


        //------------------------------------------SUB PANEL1 in SUB PANEL---------------------------------------------
        JPanel centerSubNorth = new JPanel();
        JPanel centerSubSouth = new JPanel();
        JPanel centerSubWest = new JPanel();
        JPanel centerSubEast = new JPanel();
        centerSubCenter = new JPanel();

        centerSubNorth.setBackground(new Color(62, 62, 62));
        centerSubSouth.setBackground(new Color(62, 62, 62));
        centerSubWest.setBackground(new Color(62, 62, 62));
        centerSubEast.setBackground(new Color(62, 62, 62));
        centerSubCenter.setBackground(new Color(62, 62, 62));


        centerSubNorth.setPreferredSize(new Dimension(100, 60));
        centerSubSouth.setPreferredSize(new Dimension(0, 0));
        centerSubWest.setPreferredSize(new Dimension(0, 0));
        centerSubEast.setPreferredSize(new Dimension(0, 0));
        centerSubCenter.setPreferredSize(new Dimension(100, 100));

        centerCenter.setLayout(new BorderLayout());


        centerCenter.add(centerSubNorth, BorderLayout.NORTH);
        centerCenter.add(centerSubSouth, BorderLayout.SOUTH);
        centerCenter.add(centerSubWest, BorderLayout.WEST);
        centerCenter.add(centerSubEast, BorderLayout.EAST);
        centerCenter.add(centerSubCenter, BorderLayout.CENTER);

        centerSubNorth.add(driverField);

        searchBtn.setBounds(0, 25, 100, 20);
        searchBtn.setFont(new Font("Century Gothic", Font.PLAIN, 18));
        searchBtn.setFocusable(false);//remove broader around text
        searchBtn.setForeground(new Color(62, 62, 62));
        searchBtn.setBackground(new Color(166, 166, 166));
        searchBtn.addActionListener(this);
        centerSubNorth.add(searchBtn);

        //----------------------------------------------display race info-----------------------------------------------
//        racePanel.setBackground(new Color(62, 62, 62));
//        racePanel.setPreferredSize(new Dimension(410, 370));
        //----------------------------------------------display race info-----------------------------------------------

//        String[] columnNames = {"Race ID", "Date", "Driver Count"};
//        Object[][] data;
//
//
////        for (int i = 0; i < 5; i++) {
////            data[i][0] = "Hello";//driverList.get(i).getName();
////            data[i][1] = "Hello";//driverList.get(i).getTeam();
////            data[i][2] = "Hello";//driverList.get(i).getFirstPositionCount();
////        }
//
//        data = findRaces();//receive data array with relevant data;
//
//        table = new JTable(data, columnNames) {
//            public boolean editCellAt(int row, int column, java.util.EventObject e) {
//                return false;//block cell editing
//            }
//        };
//        table.setPreferredScrollableViewportSize(new Dimension(450, 370));//width and height of table
//        table.setBackground(new Color(166, 166, 166));
//        table.setFont(new Font("Century Gothic", Font.PLAIN, 14));
//        table.setForeground(new Color(62, 62, 62));
//        table.setShowVerticalLines(false);
//        table.setGridColor(new Color(62, 62, 62));
//        table.setRowHeight(20);
//        table.setGridColor(new Color(62, 62, 62));
//        //table.setBackground();
//
//        JTableHeader header = table.getTableHeader();
//        header.setFont(new Font("Century Gothic", Font.PLAIN, 14));
//        header.setBackground(new Color(72, 72, 73));
//        header.setForeground(new Color(166, 166, 166));
//        header.setResizingAllowed(false);
//
//        //scroll pane
//        JScrollPane scrollPane = new JScrollPane(table);//interest table into scroll pane
//        scrollPane.setBackground(new Color(62, 62, 62));
//        centerSubCenter.add(scrollPane);//table is inside scroll pane
        centerSubCenter.setVisible(false);

        //------------------------------------------SUB PANEL1 in SUB PANEL---------------------------------------------
        centerPanel.add(centerNorth, BorderLayout.NORTH);
        centerPanel.add(centerSouth, BorderLayout.SOUTH);
        centerPanel.add(centerWest, BorderLayout.WEST);
        centerPanel.add(centerEast, BorderLayout.EAST);
        centerPanel.add(centerCenter, BorderLayout.CENTER);
        //------------------------------------------SUB PANELS----------------------------------------------------

        search.add(northPanel, BorderLayout.NORTH);
        search.add(westPanel, BorderLayout.WEST);
        search.add(eastPanel, BorderLayout.EAST);
        search.add(southPanel, BorderLayout.SOUTH);
        search.add(centerPanel, BorderLayout.CENTER);

        menuLabel.setBounds(0, 0, 300, 50);
        menuLabel.setFont(new Font("Century Gothic", Font.PLAIN, 30));
        menuLabel.setForeground(new Color(166, 166, 166));
        northPanel.add(menuLabel);


        driverField.setPreferredSize(new Dimension(200, 40));
        driverField.setFont(new Font("Century Gothic", Font.PLAIN, 18));
        driverField.setForeground(new Color(166, 166, 166));
        driverField.setBackground(new Color(62, 62, 62));
        driverField.setCaretColor(new Color(166, 166, 166));
        centerSubNorth.add(driverField);

        //adding back button in button panel
        backBtn.setBounds(0, 25, 400, 50);
        backBtn.setFont(new Font("Century Gothic", Font.PLAIN, 18));
        backBtn.setFocusable(false);//remove broader around text
        backBtn.setForeground(new Color(62, 62, 62));
        backBtn.setBackground(new Color(166, 166, 166));
        backBtn.addActionListener(this);
        southPanel.add(backBtn, BorderLayout.CENTER);

        search.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == backBtn) {
            search.dispose();//close current frame
            MenuFrame menu = new MenuFrame(championship);
        } else if (e.getSource() == searchBtn) {
            DefaultTableCellRenderer cellRenderer;

            driverName = driverField.getText();//stores name of driver
            System.out.println(driverName);

            String[] columnNames = {"No", "Race ID", "Date", "Time", "Driver Count"};
            Object[][] data = new Object[championship.getDrivers().size()][5];

            int i=0;

//            if (driverAvailable(driverName)) {
            for (Formula1Driver driver : driverList) {
                if (driverName.equalsIgnoreCase(driver.getName())) {
                    ArrayList<Integer> raceIds = driver.getRacesParticipated();//get the races IDs the driver has participated
                    for (int raceId : raceIds) {
                        System.out.println("Race ID: " + racesList.get(raceId - 1).getRaceId());//access the race object relevant to race Id
                        JLabel label = new JLabel("Race ID: " + racesList.get(raceId - 1).getRaceId());
                        label.setFont(new Font("Century Gothic", Font.PLAIN, 20));
                        label.setForeground(new Color(166, 166, 166));
                        racePanel.add(label);
                        System.out.println("Date & Time: " + racesList.get(raceId - 1).getDateTime());

                        String dateTime = racesList.get(raceId - 1).getDateTime();
                        String date = dateTime.substring(0,10);
                        String time = dateTime.substring(10);
                        data[i][0] = i+1;
                        data[i][1] = racesList.get(raceId - 1).getRaceId();
                        data[i][2] = date;
                        data[i][3] = time;
                        data[i][4] = racesList.get(raceId - 1).getNoOfDrivers();
                        ++i;
                    }
                }
            }
//            }
//            else {
//                System.out.println("Driver not found!");
//            }

//            for (int i = 0; i < 5; i++) {
//                data[i][0] = "Hello";//driverList.get(i).getName();
//                data[i][1] = "Hello";//driverList.get(i).getTeam();
//                data[i][2] = "Hello";//driverList.get(i).getFirstPositionCount();
//            }

            table = new JTable(data, columnNames) {
                public boolean editCellAt(int row, int column, java.util.EventObject e) {
                    return false;//block cell editing
                }
            };
            table.setPreferredScrollableViewportSize(new Dimension(495, 420));//width and height of table
            table.setBackground(new Color(166, 166, 166));
            table.setFont(new Font("Century Gothic", Font.PLAIN, 14));
            table.setForeground(new Color(62, 62, 62));
            table.setShowHorizontalLines(false);
            table.setGridColor(new Color(62, 62, 62));
            table.setRowHeight(20);
            table.setGridColor(new Color(62, 62, 62));

            cellRenderer = new DefaultTableCellRenderer();
            cellRenderer.setHorizontalAlignment(JLabel.CENTER);

            //Center align all column data
            for (int j=0; j<5; j++) {
                table.getColumnModel().getColumn(j).setCellRenderer(cellRenderer);
            }

            //make first column smaller
            table.getColumnModel().getColumn(0).setPreferredWidth(4);

            JTableHeader header = table.getTableHeader();
            header.setFont(new Font("Century Gothic", Font.PLAIN, 14));
            header.setBackground(new Color(72, 72, 73));
            header.setForeground(new Color(166, 166, 166));
            header.setResizingAllowed(false);

            //scroll pane
            JScrollPane scrollPane = new JScrollPane(table);//interest table into scroll pane
            scrollPane.setBackground(new Color(62, 62, 62));
            centerSubCenter.add(scrollPane);//table is inside scroll pane

            centerSubCenter.setVisible(true);
        }
    }


    public boolean driverAvailable(String name) {
        for (Formula1Driver driver : driverList) {
            if (driver.getName().equalsIgnoreCase(name)) {
                return true;
            }
        }
        return false;
    }
}
