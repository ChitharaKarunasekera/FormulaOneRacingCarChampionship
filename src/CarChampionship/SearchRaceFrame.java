package CarChampionship;

import javax.swing.*;
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
    JLabel raceInfo;

    Formula1ChampionshipManager championship;
    ArrayList<Race> racesList;
    ArrayList<Formula1Driver> driverList;

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
        centerCenter.setBackground(new Color(3, 252, 3 ));

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
        JPanel centerSubCenter = new JPanel();

        centerSubNorth.setBackground(new Color(252, 3, 3));
        centerSubSouth.setBackground(new Color(3, 73, 252 ));
        centerSubWest.setBackground(new Color(3, 73, 252 ));
        centerSubEast.setBackground(new Color(3, 73, 252 ));
        centerSubCenter.setBackground(new Color(252, 3, 248));


        centerSubNorth.setPreferredSize(new Dimension(100, 80));
        centerSubSouth.setPreferredSize(new Dimension(100, 50));
        centerSubWest.setPreferredSize(new Dimension(50, 100));
        centerSubEast.setPreferredSize(new Dimension(50, 100));
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
        racePanel.setBackground(new Color(62, 62, 62));
        racePanel.setPreferredSize(new Dimension(410, 370));
        //----------------------------------------------display race info-----------------------------------------------


        JScrollPane scrollPane = new JScrollPane(racePanel);//interest table into scroll pane
        centerSubCenter.add(scrollPane);//table is inside scroll pane

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
            driverName = driverField.getText();//stores name of driver
            System.out.println(driverName);

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
                        }
                    }
                }
//            }
//            else {
//                System.out.println("Driver not found!");
//            }
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
