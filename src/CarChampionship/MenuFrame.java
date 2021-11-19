package CarChampionship;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.file.OpenOption;

public class MenuFrame implements ActionListener{
    JFrame menuFrame = new JFrame("Formula 1 Car Racing Championship");
    JLabel menuLabel = new JLabel("Main Menu");

    JButton option1 = new JButton("Option one");
    JButton option2 = new JButton("Option two");
    JButton option3 = new JButton("Option three");
    JButton option4 = new JButton("Option four");
    JButton option5 = new JButton("Option five");
    JButton option6 = new JButton("Option six");
    JButton option7 = new JButton("Option seven");

    JButton[] options = {option1, option2, option3, option4, option5, option6, option7};

    public MenuFrame() {
        menuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        menuFrame.setSize(550, 500);
        menuFrame.setLayout(new BorderLayout(10, 0));//add margin between components
        ImageIcon image = new ImageIcon("images/CompanyName.png");//create an image icon for frame icon
        menuFrame.setIconImage(image.getImage());//change icon of frame
        menuFrame.getContentPane().setBackground(new Color(79, 79, 79));//background color of frame


        JPanel northPanel = new JPanel();
        JPanel westPanel = new JPanel();
        JPanel eastPanel = new JPanel();
        JPanel southPanel = new JPanel();
        JPanel centerPanel = new JPanel();

        northPanel.setBackground(new Color(109, 109, 109));
        westPanel.setBackground(new Color(109, 109, 109));
        eastPanel.setBackground(new Color(109, 109, 109));
        southPanel.setBackground(new Color(109, 109, 109));
        centerPanel.setBackground(new Color(79, 79, 79));

        northPanel.setPreferredSize(new Dimension(100, 50));
        westPanel.setPreferredSize(new Dimension(100, 100));
        eastPanel.setPreferredSize(new Dimension(100, 100));
        southPanel.setPreferredSize(new Dimension(100, 50));
        centerPanel.setPreferredSize(new Dimension(100, 100));

        menuFrame.add(northPanel, BorderLayout.NORTH);
        menuFrame.add(westPanel, BorderLayout.WEST);
        menuFrame.add(eastPanel, BorderLayout.EAST);
        menuFrame.add(southPanel, BorderLayout.SOUTH);
        menuFrame.add(centerPanel, BorderLayout.CENTER);

        menuLabel.setBounds(0,0,300,50);
        menuLabel.setFont(new Font("Century Gothic",Font.PLAIN, 25));
        northPanel.add(menuLabel);

        centerPanel.setLayout(new GridLayout(7,1,10,10));

        for (JButton option: options){
            option.setFocusable(false);//remove broader around text
            option.setFont(new Font("Century Gothic", Font.PLAIN,20));
            option.setForeground(Color.darkGray);
            option.setBackground(Color.lightGray);
            centerPanel.add(option);
            option.addActionListener(this);
        }

        menuFrame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == option1){
            menuFrame.dispose();
            DriverStatsFrame tableWindow = new DriverStatsFrame();
        }
    }

}
