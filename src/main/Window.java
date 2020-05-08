package main;

import javax.swing.*;

public class Window extends JFrame {
   public static MainMenu menu;
   public JButton exitButtom;

   public Window(){

        setVisible(true);
        menu =  new MainMenu();
        add(menu);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(600 ,400);








    }



}
