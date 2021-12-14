package CarChampionship;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class RacesFrame implements ActionListener {
    private int number = 1;
    private JFrame race = new JFrame("Formula 1 Car Racing Championship");
    private JLabel titleLabel = new JLabel("Completed Races");
    private JButton backBtn = new JButton("Back to Main Menu");

    private Formula1ChampionshipManager championship;
    private ArrayList<Race> racesList;

    private Font nfsTitle;
    private Font russoNormal;

    private Border border = BorderFactory.createLineBorder(Color.BLUE, 1);

    public RacesFrame(Formula1ChampionshipManager championship){
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

        race.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        race.setSize(600, 700);
        race.setLayout(new BorderLayout(0, 0));//add margin between components
        ImageIcon image = new ImageIcon("images/F1-logo.png");//create an image icon for frame icon
        race.setIconImage(image.getImage());//change icon of frame
        //menuFrame.getContentPane().setBackground(new Color(79, 79, 79));//background color of frame
        race.setLocationRelativeTo(null);//open frame in center of screen


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
        centerCenter.setBackground(new Color(3, 0, 69));

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

        race.add(northPanel, BorderLayout.NORTH);
        race.add(westPanel, BorderLayout.WEST);
        race.add(eastPanel, BorderLayout.EAST);
        race.add(southPanel, BorderLayout.SOUTH);
        race.add(centerPanel, BorderLayout.CENTER);

        titleLabel.setBounds(0, 0, 300, 50);
        titleLabel.setFont(nfsTitle);
        titleLabel.setForeground(new Color(255, 255, 255));
        northPanel.add(titleLabel);

        //centerCenter.setLayout(new GridLayout(10, 1, 10, 10));

        //Display race number, date and time of every race a diver has participated in a label
        for (Race thisRace: racesList){
            ImageIcon carIcon = new ImageIcon("car_icon.png");
            JLabel label = new JLabel(" Race " + thisRace.getRaceId() + " on " + thisRace.getDate());

            label.setFont(new Font("Century Gothic", Font.PLAIN, 20));
            label.setForeground(new Color(158, 184, 228));

            label.setIcon(carIcon);
            centerCenter.add(label);
            ++number;
        }


        //adding back button in button panel
        backBtn.setBounds(0,25,400,50);
        backBtn.setFont(russoNormal);
        backBtn.setFocusable(false);//remove broader around text
        backBtn.setForeground(new Color(255, 255, 255));
        backBtn.setBackground(new Color(213, 0, 9));
        backBtn.addActionListener(this);
        southPanel.add(backBtn, BorderLayout.CENTER);

        race.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == backBtn){
            race.dispose();//close current frame
            MenuFrame menu = new MenuFrame(championship);
        }
    }
}