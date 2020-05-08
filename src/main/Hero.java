package main;

import java.io.Serializable;

public class Hero implements Serializable {
    private String name;
    private int max_health;
    private int damage;
    private int range;
    private int attack_speed;
    private int health;


    Hero(String n, int h, int d, int r, int as){
        this.name = n;
        this.max_health = h;
        this.damage = d;
        this.range = r;
        this.attack_speed = as;
        this.health = h;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getRange() {
        return range;
    }

    public void setRange(int range) {
        this.range = range;
    }

    public int getAttack_speed() {
        return attack_speed;
    }

    public void setAttack_speed(int attack_speed) {
        this.attack_speed = attack_speed;
    }

    public int getMax_health() {
        return max_health;
    }

    public void setMax_health(int max_health) {
        this.max_health = max_health;
    }
@Override
    public String toString(){
        return name;
}
}