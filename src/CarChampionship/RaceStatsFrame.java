package CarChampionship;

import javax.swing.*;
import java.awt.*;

public class RaceStatsFrame {
    JFrame tableFrame = new JFrame("Formula 1 Car Racing Championship");
    JTable table;

    public RaceStatsFrame(){

        tableFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        tableFrame.setSize(900, 700);
        tableFrame.setLayout(new BorderLayout(0, 0));//add margin between components
        ImageIcon image = new ImageIcon("images/CompanyName.png");//create an image icon for frame icon
        tableFrame.setIconImage(image.getImage());//change icon of frame
    }
}
