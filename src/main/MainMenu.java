package main;
import project.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class MainMenu extends Container{
    private JButton addButton;
    private JLabel listLabel;
    private JComboBox listBox;
    private JComboBox listBox1;
    private JButton exitButton;



    public MainMenu(){
        ArrayList<Hero> geroi = new ArrayList<Hero>();
        geroi.add(new Hero("Anti-Mage", 600, 50, 100, 200));
        geroi.add(new Hero("ShadowFiend", 600, 75,300,100));
        geroi.add(new Hero("Roshan", 600, 600,600,600));


        setSize(600, 400);
        setLayout(null);

        listLabel =  new JLabel("Choose your Hero");
        listLabel.setBounds(10, 200, 50,50);
        add(listLabel);

        listBox = new JComboBox(geroi.toArray());
        listBox.setBounds(70,200, 100, 50);
        add(listBox);


        listBox1 = new JComboBox(geroi.toArray() );
        listBox1.setBounds(420, 200, 150, 50);


        add(listBox1);

        addButton = new JButton( "PLAY");
        addButton.setBounds(225, 50, 150, 50);
        addButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
        Arena map = new Arena((Hero)listBox.getSelectedItem(), (Hero)listBox1.getSelectedItem(), 400);
            Main.frame1 =  new Frame(new Animation(map));
            Main.frame1.setVisible(true);

            Main.frame.setVisible(false);
        }
        });
        add(addButton);

        exitButton = new JButton("EXIT");
        exitButton.setBounds(225, 300, 150, 50);
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        add(exitButton);

    }



}
