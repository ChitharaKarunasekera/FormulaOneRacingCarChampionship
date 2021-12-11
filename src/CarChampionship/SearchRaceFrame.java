package CarChampionship;

import javax.swing.*;
import javax.swing.plaf.basic.BasicScrollBarUI;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class SearchRaceFrame implements ActionListener {

    private JFrame search = new JFrame("Formula 1 Car Racing Championship");
    private JLabel menuLabel = new JLabel("Completed Races");
    private JButton backBtn = new JButton("Back to Main Menu");
    private JTextField driverField = new JTextField();//adding text field
    private JButton searchBtn = new JButton("Search");
    private JPanel racePanel = new JPanel();
    private JPanel centerSubCenter;

    private Formula1ChampionshipManager championship;
    private ArrayList<Race> racesList;
    private ArrayList<Formula1Driver> driverList;

    private JTable table;

    private String driverName;

    private Font nfsTitle;
    private Font russoNormal;


    public SearchRaceFrame(Formula1ChampionshipManager championship) {
        //try read NFS title text
        try {
            nfsTitle = Font.createFont(Font.TRUETYPE_FONT, new File("CustomFonts/NFS_by_JLTV.ttf")).deriveFont(40f);
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("CustomFonts/NFS_by_JLTV.ttf")));
        }
        catch (IOException | FontFormatException e){

        }

        //try read Russo_one title text
        try {
            russoNormal = Font.createFont(Font.TRUETYPE_FONT, new File("CustomFonts/Russo_One.ttf")).deriveFont(20f);
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("CustomFonts/Russo_One.ttf")));
        }
        catch (IOException | FontFormatException e){

        }


        this.championship = championship;
        this.racesList = championship.getRaces();//races list from championship class
        this.driverList = championship.getDrivers();//drivers list from championship

        search.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        search.setSize(700, 700);
        search.setLayout(new BorderLayout(0, 0));//add margin between components
        ImageIcon image = new ImageIcon("images/F1-logo.png");//create an image icon for frame icon
        search.setIconImage(image.getImage());//change icon of frame
        //menuFrame.getContentPane().setBackground(new Color(79, 79, 79));//background color of frame
        search.setLocationRelativeTo(null);//open frame in center of screen


        JPanel northPanel = new JPanel();
        JPanel westPanel = new JPanel();
        JPanel eastPanel = new JPanel();
        JPanel southPanel = new JPanel();
        JPanel centerPanel = new JPanel();

        northPanel.setBackground(new Color(4, 0, 94));
        westPanel.setBackground(new Color(4, 0, 94));
        eastPanel.setBackground(new Color(4, 0, 94));
        southPanel.setBackground(new Color(4, 0, 94));
        centerPanel.setBackground(new Color(4, 0, 94));

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

        centerNorth.setBackground(new Color(3, 0, 69));
        centerSouth.setBackground(new Color(3, 0, 69));
        centerWest.setBackground(new Color(3, 0, 69));
        centerEast.setBackground(new Color(3, 0, 69));
        centerCenter.setBackground(new Color(158, 184, 228));

        centerNorth.setLayout(new FlowLayout());
        centerPanel.setLayout(new BorderLayout());

        centerNorth.setPreferredSize(new Dimension(25, 25));
        centerSouth.setPreferredSize(new Dimension(25, 25));
        centerWest.setPreferredSize(new Dimension(35, 25));
        centerEast.setPreferredSize(new Dimension(35, 25));
        centerCenter.setPreferredSize(new Dimension(25, 25));

        JLabel guidance = new JLabel("Enter driver's name to search participated races");
        guidance.setBounds(0, 0, 300, 50);
        guidance.setFont(russoNormal.deriveFont(16f));
        guidance.setForeground(new Color(255, 255, 255));
        centerNorth.add(guidance);


        //------------------------------------------SUB PANEL1 in SUB PANEL---------------------------------------------
        JPanel centerSubNorth = new JPanel();
        JPanel centerSubSouth = new JPanel();
        JPanel centerSubWest = new JPanel();
        JPanel centerSubEast = new JPanel();
        centerSubCenter = new JPanel();

        centerSubNorth.setBackground(new Color(3, 0, 69));
        centerSubSouth.setBackground(new Color(3, 0, 69));
        centerSubWest.setBackground(new Color(3, 0, 69));
        centerSubEast.setBackground(new Color(3, 0, 69));
        centerSubCenter.setBackground(new Color(3, 0, 69));


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
        searchBtn.setFont(russoNormal);
        searchBtn.setFocusable(false);//remove broader around text
        searchBtn.setForeground(new Color(255, 255, 255));
        searchBtn.setBackground(new Color(213, 0, 9));
        searchBtn.addActionListener(this);
        centerSubNorth.add(searchBtn);

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
        menuLabel.setFont(nfsTitle);
        menuLabel.setForeground(new Color(255, 255, 255));
        northPanel.add(menuLabel);


        driverField.setPreferredSize(new Dimension(200, 40));
        driverField.setFont(new Font("Century Gothic", Font.PLAIN, 18));
        driverField.setForeground(new Color(158, 184, 228));
        driverField.setBackground(new Color(3, 0, 69));
        driverField.setCaretColor(new Color(158, 184, 228));
        centerSubNorth.add(driverField);

        //adding back button in button panel
        backBtn.setBounds(0, 25, 400, 50);
        backBtn.setFont(russoNormal);
        backBtn.setFocusable(false);//remove broader around text
        backBtn.setForeground(new Color(255, 255, 255));
        backBtn.setBackground(new Color(213, 0, 9));
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

            for (Formula1Driver driver : driverList) {
                if (driverName.equalsIgnoreCase(driver.getName())) {
                    System.out.println("Driver found!");
                    ArrayList<Integer> raceIds = driver.getRacesParticipated();//get the races IDs the driver has participated
                    for (int raceId : raceIds) {
                        String dateTime = racesList.get(raceId - 1).getDateTime();
                        String date = dateTime.substring(0,10);
                        String time = dateTime.substring(10);
                        data[i][0] = (i+1) + ".";
                        data[i][1] = racesList.get(raceId - 1).getRaceId();
                        data[i][2] = date;
                        data[i][3] = time;
                        data[i][4] = racesList.get(raceId - 1).getNoOfDrivers();

                        System.out.println("ID: " + racesList.get(raceId - 1).getRaceId());
                        System.out.println("Date: " + date);
                        System.out.println("Time: " + time);
                        System.out.println("Drivers: " + racesList.get(raceId - 1).getNoOfDrivers());
                        System.out.println("\n");

                        ++i;
                    }
                }
            }

            table = new JTable(data, columnNames) {
                public boolean editCellAt(int row, int column, java.util.EventObject e) {
                    return false;//block cell editing
                }
            };
            table.setPreferredScrollableViewportSize(new Dimension(495, 420));//width and height of table
            table.setBackground(new Color(158, 184, 228));
            table.setFont(new Font("Century Gothic", Font.PLAIN, 16));
            table.setForeground(new Color(3, 0, 69));
            table.setShowHorizontalLines(false);
            table.setGridColor(new Color(3, 0, 69));
            table.setRowHeight(30);
            table.setGridColor(new Color(3, 0, 69));

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
            header.setBackground(new Color(3, 0, 69));
            header.setForeground(new Color(158, 184, 228));
            header.setResizingAllowed(false);

            //scroll pane
            JScrollPane scrollPane = new JScrollPane(table);//interest table into scroll pane
            scrollPane.getVerticalScrollBar().setUI(new BasicScrollBarUI() {
                @Override
                protected void configureScrollBarColors() {
                    this.thumbColor = new Color(3, 0, 69);
                }
            });
            scrollPane.setBackground(new Color(3, 0, 69));
            centerSubCenter.add(scrollPane);//table is inside scroll pane

            centerSubCenter.setVisible(true);
        }
    }
}
