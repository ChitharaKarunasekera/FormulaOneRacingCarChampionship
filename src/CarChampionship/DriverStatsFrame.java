package CarChampionship;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DriverStatsFrame extends MenuFrame implements ActionListener {
    JFrame tableFrame = new JFrame("Formula 1 Car Racing Championship");
    JLabel label = new JLabel("Statistics of Drivers");
    JButton backBtn = new JButton("Back to Main Menu");
    JTable table;

    public DriverStatsFrame(){
        tableFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        tableFrame.setSize(900, 700);
        tableFrame.setLayout(new BorderLayout(10, 10));//add margin between components
        ImageIcon image = new ImageIcon("images/CompanyName.png");//create an image icon for frame icon
        tableFrame.setIconImage(image.getImage());//change icon of frame

        JPanel northPanel = new JPanel();
        JPanel westPanel = new JPanel();
        JPanel eastPanel = new JPanel();
        JPanel southPanel = new JPanel();
        JPanel centerPanel = new JPanel();

        northPanel.setBackground(Color.red);
        westPanel.setBackground(Color.green);
        eastPanel.setBackground(Color.yellow);
        southPanel.setBackground(Color.magenta);
        centerPanel.setBackground(Color.blue);

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
        northPanel.add(label);

        //adding back button in button panel
        backBtn.setBounds(0,25,400,50);
        backBtn.setFont(new Font("Century Gothic",Font.PLAIN, 18));
        backBtn.setFocusable(false);//remove broader around text
        backBtn.addActionListener(this);
        southPanel.add(backBtn, BorderLayout.CENTER);

        //Table
        String[] columnNames = {"Driver Name", "Team Name", "1st Positions", "2nd Positions", "3rd Positions", "Points", "Completed"};
        Object[][] data = {
                {"Bill", "Hazel", "Male", "Male", "Male", "Male", "Male"},
                {"Mary", "Black", "Female", "Male", "Male", "Male", "Male"},
                {"Rick", "Red", "Male", "Male", "Male", "Male", "Male"},
                {"Janice", "Yellow", "Female", "Male", "Male", "Male", "Male"},
        };

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
            MenuFrame menu = new MenuFrame();
        }
    }
}
