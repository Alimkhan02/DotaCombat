package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;

public class Frame extends JFrame{
    static Animation paint;
    public Frame(Animation paint) {
        this.paint = paint;
        this.setSize(600, 400);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.add(paint);

        new Thread(paint).start();
        this.addKeyListener(new KeyListener(){

            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_LEFT)
                    paint.hero1_control[0] = true;
                else if(e.getKeyCode() == KeyEvent.VK_RIGHT)
                    paint.hero1_control[1] = true;

                if(e.getKeyCode() == KeyEvent.VK_A)
                    paint.hero2_control[0] = true;
                else if(e.getKeyCode() == KeyEvent.VK_D)
                    paint.hero2_control[1] = true;

                if(e.getKeyCode() == KeyEvent.VK_S)
                    paint.hero1_control[2] = true;

                if(e.getKeyCode() == KeyEvent.VK_DOWN)
                    paint.hero2_control[2] = true;

            }

            @Override
            public void keyReleased(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_LEFT)
                    paint.hero1_control[0] = false;
                else if(e.getKeyCode() == KeyEvent.VK_RIGHT)
                    paint.hero1_control[1] = false;

                if(e.getKeyCode() == KeyEvent.VK_A)
                    paint.hero2_control[0] = false;
                else if(e.getKeyCode() == KeyEvent.VK_D)
                    paint.hero2_control[1] = false;

                if(e.getKeyCode() == KeyEvent.VK_S)
                    paint.hero1_control[2] = false;

                if(e.getKeyCode() == KeyEvent.VK_DOWN)
                    paint.hero2_control[2] = false;
            }
        });


    }

}
