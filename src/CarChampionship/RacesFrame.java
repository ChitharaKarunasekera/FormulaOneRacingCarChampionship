package CarChampionship;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class RacesFrame implements ActionListener {
    int number = 1;
    JFrame menuFrame = new JFrame("Formula 1 Car Racing Championship");
    JLabel menuLabel = new JLabel("Completed Races");
    JButton backBtn = new JButton("Back to Main Menu");

    Formula1ChampionshipManager championship;
    ArrayList<Race> racesList;

    //Border border = BorderFactory.createLineBorder(Color.BLUE, 1);

    public RacesFrame(Formula1ChampionshipManager championship){
        this.championship = championship;
        this.racesList = championship.getRaces();//races list from championship class

        menuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        menuFrame.setSize(500, 700);
        menuFrame.setLayout(new BorderLayout(0, 0));//add margin between components
        ImageIcon image = new ImageIcon("images/CompanyName.png");//create an image icon for frame icon
        menuFrame.setIconImage(image.getImage());//change icon of frame
        //menuFrame.getContentPane().setBackground(new Color(79, 79, 79));//background color of frame
        menuFrame.setLocationRelativeTo(null);//open frame in center of screen


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
        centerCenter.setBackground(new Color(62, 62, 62));

        centerPanel.setLayout(new BorderLayout());

        centerNorth.setPreferredSize(new Dimension(25, 25));
        centerSouth.setPreferredSize(new Dimension(25, 25));
        centerWest.setPreferredSize(new Dimension(35, 25));
        centerEast.setPreferredSize(new Dimension(35, 25));
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

        for (Race thisRace: racesList){
            JLabel label = new JLabel(" Race " + number + " on " + thisRace.getDateTime());

            label.setFont(new Font("Century Gothic", Font.PLAIN, 20));
            label.setForeground(new Color(166, 166, 166));
            centerCenter.add(label);
            //label.setBorder(border);// set the border of this component
            ++number;
        }


        //adding back button in button panel
        backBtn.setBounds(0,25,400,50);
        backBtn.setFont(new Font("Century Gothic",Font.PLAIN, 18));
        backBtn.setFocusable(false);//remove broader around text
        backBtn.setForeground(new Color(62, 62, 62));
        backBtn.setBackground(new Color(166, 166, 166));
        backBtn.addActionListener(this);
        southPanel.add(backBtn, BorderLayout.CENTER);

        menuFrame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == backBtn){
            menuFrame.dispose();//close current frame
            MenuFrame menu = new MenuFrame(championship);
        }
    }
}