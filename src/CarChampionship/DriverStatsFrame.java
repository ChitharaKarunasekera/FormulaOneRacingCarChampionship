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

public class DriverStatsFrame implements ActionListener {
    private JFrame tableFrame = new JFrame("Formula 1 Car Racing Championship");
    private JLabel tblTitle = new JLabel("Statistics of Drivers");
    private JButton backBtn = new JButton("Back to Main Menu");
    private JTable table;
    private DefaultTableCellRenderer cellRenderer;

    private Formula1ChampionshipManager championship;
    private ArrayList<Formula1Driver> driverList;
    private ArrayList<Race> races;

    private Font nfsTitle;
    private Font russoNormal;

    public DriverStatsFrame(Formula1ChampionshipManager championship){
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
        this.driverList = championship.getDrivers();//driver list from championship manager class
        this.races = championship.getRaces();

        tableFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        tableFrame.setSize(1000, 500);
        tableFrame.setLayout(new BorderLayout(0, 0));//add margin between components
        ImageIcon image = new ImageIcon("images/F1-logo.png");//create an image icon for frame icon
        tableFrame.setIconImage(image.getImage());//change icon of frame
        tableFrame.setLocationRelativeTo(null);//open frame in center of screen
        tableFrame.setResizable(false);

        JPanel northPanel = new JPanel();
        JPanel westPanel = new JPanel();
        JPanel eastPanel = new JPanel();
        JPanel southPanel = new JPanel();
        JPanel centerPanel = new JPanel();

        northPanel.setBackground(new Color(4, 0, 94));
        westPanel.setBackground(new Color(4, 0, 94));
        eastPanel.setBackground(new Color(4, 0, 94));
        southPanel.setBackground(new Color(4, 0, 94));
        centerPanel.setBackground(new Color(3, 0, 69));

        northPanel.setPreferredSize(new Dimension(100, 50));
        westPanel.setPreferredSize(new Dimension(25, 100));
        eastPanel.setPreferredSize(new Dimension(25, 100));
        southPanel.setPreferredSize(new Dimension(100, 50));
        centerPanel.setPreferredSize(new Dimension(100, 100));

        tableFrame.add(northPanel, BorderLayout.NORTH);
        tableFrame.add(westPanel, BorderLayout.WEST);
        tableFrame.add(eastPanel, BorderLayout.EAST);
        tableFrame.add(southPanel, BorderLayout.SOUTH);
        tableFrame.add(centerPanel, BorderLayout.CENTER);

        //adding label as topic in top panel
        tblTitle.setBounds(0,0,820,50);
        tblTitle.setFont(nfsTitle);
        tblTitle.setForeground(new Color(255, 255, 255));
        northPanel.add(tblTitle);

        //adding back button in button panel
        backBtn.setBounds(0,25,400,50);
        backBtn.setFont(russoNormal);
        backBtn.setFocusable(false);//remove broader around text
        backBtn.setForeground(new Color(255, 255, 255));
        backBtn.setBackground(new Color(213, 0, 9));
        backBtn.addActionListener(this);
        southPanel.add(backBtn, BorderLayout.CENTER);

        //Table
        String[] columnNames = {"Driver Name", "Team Name", "1st Positions", "2nd Positions", "3rd Positions", "Points", "Completed", "Start Position", "Position Won"};

        Object[][] data = new Object[championship.getDrivers().size()][9];//2D array that holds data for the table


        //populate data array with relevant data
        for (int i=0; i<driverList.size(); i++){
            data[i][0] = driverList.get(i).getName();
            data[i][1] = driverList.get(i).getTeam();
            data[i][2] = driverList.get(i).getFirstPositionCount();
            data[i][3] = driverList.get(i).getSecondPositionCount();
            data[i][4] = driverList.get(i).getThirdPositionCount();
            data[i][5] = driverList.get(i).getPoints();
            data[i][6] = driverList.get(i).getRacesCount();
            //display N/A for races where a start position was not given
            if (driverList.get(i).getStartingPosition() == 0){
                data[i][7] = "N/A";
            }
            else {
                data[i][7] = driverList.get(i).getStartingPosition();
            }
            data[i][8] = driverList.get(i).getCurrentPositions();
        }

        table = new JTable(data, columnNames){
            public boolean editCellAt(int row, int column, java.util.EventObject e) {
                return false;//block cell editing
            }
        };

        //Styling table
        table.setPreferredScrollableViewportSize(new Dimension(910, 328));//width and height of table
        table.setBackground(new Color(158, 184, 228));
        table.setFont(new Font("Century Gothic",Font.PLAIN, 16));
        table.setForeground(new Color(3, 0, 69));
        table.setShowVerticalLines(false);
        table.setGridColor(new Color(3, 0, 69));
        table.setRowHeight(30);
        table.setGridColor(new Color(3, 0, 69));

        cellRenderer = new DefaultTableCellRenderer();
        cellRenderer.setHorizontalAlignment(JLabel.CENTER);

        //Center align all column data
        for (int j=0; j<9; j++) {
            table.getColumnModel().getColumn(j).setCellRenderer(cellRenderer);
        }


        //make first column smaller
        table.getColumnModel().getColumn(5).setPreferredWidth(25);

        JTableHeader header = table.getTableHeader();
        header.setFont(new Font("Century Gothic",Font.PLAIN, 14));
        header.setBackground(new Color(3, 0, 69));
        header.setForeground(new Color(255, 255, 255));
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
        centerPanel.add(scrollPane);//table is inside scroll pane

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