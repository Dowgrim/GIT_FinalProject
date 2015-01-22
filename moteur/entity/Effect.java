package moteur.entity;

import moteur.entity.Entity;

/**
 * Created by user on 22/01/15.
 */
public abstract class Effect implements  Comparable<Effect>{
    private int power;

    public Effect(int power) {
        this.power = power;
    }

    public int getPower() {
        return this.power;
    }


    public abstract void apply(Entity player);

    @Override
    public int compareTo(Effect o) {
        if(o.getPower() == this.getPower()){
            return 0;
        }
        if(o.getPower() > this.getPower()){
            return -1;
        }
        else {
            return 1;
        }
    }
}
