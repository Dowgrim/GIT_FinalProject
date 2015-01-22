package moteur.item;

/**
 * Created by user on 22/01/2015.
 */
public class FightingItem extends Item {
    private int strength;

    public FightingItem(String desc, int strength) {
        super(desc);
        this.strength = strength;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }
}
