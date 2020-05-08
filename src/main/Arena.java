package main;


import main.Hero;

public class Arena {
    float hero1_pos;
    float hero2_pos;
    private Hero hero1;
    private Hero hero2;
    int arena_size;

    public Arena(Hero hero1, Hero hero2, int arena_size) {
        this.hero1 = hero1;
        this.hero2 = hero2;
        this.arena_size = arena_size;
        this.hero1_pos = 1;
        this.hero2_pos = arena_size-1;
}

    public int getArena_size() {
        return arena_size;
    }

    public float getHero1_pos() {
        return hero1_pos;
    }

    public float getHero2_pos() {
        return hero2_pos;
    }

    public Hero getHero1() {
        return hero1;
    }

    public Hero getHero2() {
        return hero2;
    }

    @Override
    public String toString (){   //проверка
        String temp = "" + hero1.getName() + " " + hero1.getHealth() + " " + hero1_pos + "\n";
        temp += hero2.getName() + " " + hero2.getHealth() + " " + hero2_pos + " ";

        return temp;
    }
    public void walk (int hero_num, boolean left_right){//передвежение героев
        if(check(hero_num, left_right)){

            if (hero_num == 1)
                if(left_right)
                    hero1_pos++;
                else hero1_pos--;
            if (hero_num == 2)
                if(left_right)
                    hero2_pos++;
                else hero2_pos--;
        }

    }
    public void hit (int hero_num){//бить
        if (hero_num == 1)

            if (Math.abs(hero1_pos - hero2_pos)<hero1.getRange())
                hero2.setHealth(hero2.getHealth() - hero1.getDamage());
        if (hero_num == 2)

            if (Math.abs(hero2_pos - hero1_pos)<hero2.getRange())
                hero1.setHealth(hero1.getHealth() - hero2.getDamage());


    }
    private boolean check(int hero_num, boolean left_right){//проверка за арену
        int temp = 0;
        if (hero_num == 1)
            if(left_right)
                temp = (int)hero1_pos +1;
            else temp = (int)hero1_pos -1;
        if (hero_num == 2)
            if(left_right)
                temp = (int)hero2_pos +1;
            else temp = (int)hero2_pos -1;

        if( (temp > arena_size)| (temp<0) )
            return false;
        else
            return true;
    }
    public int win(){

        if((hero1.getHealth()<=0) | (hero2.getHealth()<=0))
            if(hero1.getHealth()< hero2.getHealth())
                return 2;
            else return 1;
            else return -1;
    }
public boolean check1(){
    if (Math.abs(hero1_pos - hero2_pos)<hero1.getRange())
        return true;
    else return false;
}

    public boolean check2(){
        if (Math.abs(hero1_pos - hero2_pos)<hero2.getRange())
            return true;
        else return false;
    }
}
