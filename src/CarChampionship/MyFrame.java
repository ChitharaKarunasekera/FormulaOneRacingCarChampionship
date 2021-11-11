package CarChampionship;

import javax.swing.*;
import java.awt.*;

public class MyFrame extends JFrame {

    public MyFrame(){
        //default frame
        this.setTitle("Formula 1 Car Racing Championship");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setSize(420,420);
        this.setVisible(true);// make table visible

        ImageIcon image = new ImageIcon("images/CompanyName.png");//create an image icon
        this.setIconImage(image.getImage());//change icon of frame
        this.getContentPane().setBackground(new Color(63, 63, 63));//background color of frame
    }

}
