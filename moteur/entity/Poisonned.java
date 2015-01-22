package moteur.entity;

/**
 * Created by user on 22/01/15.
 */
public class Poisonned extends Effect{

    public Poisonned(int power) {
        super(power);
    }

    @Override
    public void apply(Entity player) {
        player.decreaseEnergy(this.getPower()*2);
    }

}
