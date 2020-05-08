package project;
import java.io.Serializable;
import java.util.ArrayList;
import main.Hero;


public class PackageData implements Serializable {
    String operationType;
    ArrayList<Hero> heroes;
    Hero hero;

    public PackageData() {
    }

    public PackageData(String operationType, ArrayList<Hero> heroes, Hero hero) {
        this.operationType = operationType;
        this.heroes = heroes;
        this.hero = hero;
    }

    public String getOperationType() {
        return operationType;
    }

    public void setOperationType(String operationType) {
        this.operationType = operationType;
    }

    public ArrayList<Hero> getHeroes() {
        return heroes;
    }

    public void setHeroes(ArrayList<Hero> heroes) {
        this.heroes = heroes;
    }

    public Hero getHero() {
        return hero;
    }

    public void setHero(Hero hero) {
        this.hero = hero;
    }


}
