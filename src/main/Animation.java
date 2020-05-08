package main;

import project.Main;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComponent;

public class Animation extends JComponent implements Runnable{
    static Arena arena;
    boolean[]hero1_control;
    boolean[]hero2_control;
    private final int attack_timer = 10000;
    private int timer1;
    private int timer2;
    private int hp_bar;
    private int won = -1;
    boolean hero1_hit;
    boolean hero2_hit;



    public Animation(Arena arena) {
        this.arena = arena;
        hero1_control = new boolean[3];//0 у нас в лево 1 направо 2 бить
        hero2_control = new boolean[3];
        this.timer1 = 0;
        this.timer2 = 0;
        this.hp_bar = arena.getArena_size()/3;
    }

    public Animation() {

    }

    @Override
    protected void paintComponent(Graphics g){//отрисовка героев
        Graphics2D painter = (Graphics2D) g;

        painter.setColor(new Color(101, 67, 33));//насышенный 150 75 0
        painter.fillRect(0, 300, arena.getArena_size(), 300);
        painter.drawRect(0, 0, hp_bar, 20);
        painter.drawRect(2*hp_bar , 0, hp_bar, 20);

        painter.setColor(Color.red);
        painter.drawLine((int)arena.getHero1_pos(), 300, (int)arena.getHero1_pos(), 250);
        if( (hero1_hit) & arena.check1())
            painter.drawLine((int)arena.getHero2_pos(), 280, (int)(arena.getHero1_pos()), 280);
        painter.fillRect(0, 0, arena.getArena_size()/3*arena.getHero1().getHealth()/arena.getHero1().getMax_health(), 20);

        painter.setColor(Color.blue);
        painter.drawLine((int)arena.getHero2_pos(), 300, (int)arena.getHero2_pos(), 250);
        if( (hero2_hit) & arena.check2())
            painter.drawLine((int)arena.getHero2_pos(), 280, (int)(arena.getHero1_pos()), 280);
        painter.fillRect(arena.getArena_size()-arena.getArena_size()/3*arena.getHero2().getHealth()/arena.getHero2().getMax_health() , 0, arena.getArena_size()/3*arena.getHero2().getHealth()/arena.getHero2().getMax_health(), 20);

        if(won != -1) {
            painter.setFont(new Font("TimesRoman", Font.PLAIN, 40));
            painter.setColor(Color.GREEN);
            painter.drawString("PLAYER " + won + " WON", 10, 50 );
        }
    }

    @Override
    public void run() {   //контроль для героев
        while (arena.win() == -1){
            this.repaint();      //нарисовать заного
            if(timer1 < attack_timer) {
                hero1_hit = false;

                timer1 += arena.getHero1().getAttack_speed();//1 тик`` = 20мс
            }

            if(timer2 < attack_timer) {
                timer2 += arena.getHero2().getAttack_speed();
            hero2_hit = false;
            }
            if(hero1_control[0])
                arena.walk(1, false);

            if(hero1_control[1])
                arena.walk(1, true);

            if(hero2_control[0])
                arena.walk(2, false);
            if(hero2_control[1])
                arena.walk(2, true);

            if(hero1_control[2])
                if(timer1 >= attack_timer){
                    hero1_hit = true;

                    arena.hit(1);
                    timer1 = 0;
                }
            if(hero2_control[2])
                if(timer2 >= attack_timer){
                    hero2_hit = true;
                    arena.hit(2);
                    timer2 = 0;
                }



            System.out.println(arena);

            try {
                Thread.sleep(50);
            }
            catch (InterruptedException ex) {
                Logger.getLogger(Animation.class.getName()).log(Level.SEVERE, null, ex);//контроль ошибок
            }



        }
        won = arena.win();
        repaint();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Main.frame1.setVisible(false);
        Main.frame.setVisible(true);


    }
}
