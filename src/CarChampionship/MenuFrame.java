package CarChampionship;

import javax.swing.*;
import java.awt.*;

public class MenuFrame {
    JFrame menuFrame = new JFrame("Formula 1 Car Racing Championship");
    JLabel menuLabel = new JLabel("Main Menu.");

    public MenuFrame() {
        menuLabel.setBounds(200,40,100,50);
        menuLabel.setFont(new Font(null,Font.PLAIN, 12));
        menuFrame.add(menuLabel);

        menuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        menuFrame.setSize(500, 500);
        menuFrame.setLayout(null);
        menuFrame.setVisible(true);
    }

}
