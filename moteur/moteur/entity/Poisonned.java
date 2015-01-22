package moteur.entity;

/**
 * Created by user on 22/01/15.
 */
public class Poisonned implements Effect{
    private int power;

    public Poisonned (int power) {
        this.power = power;
    }

    public void apply (Entity player) {

    }
}
