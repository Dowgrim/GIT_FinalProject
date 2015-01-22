package moteur.item;

import moteur.entity.Entity;

/**
 * Created by user on 22/01/2015.
 */
public class FightingItem extends Usable {
    private int strength;

    public FightingItem(String desc, String name, int strength) {
        super(desc,name);
        this.strength = strength;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public void use(Entity player){
        
    }
}
