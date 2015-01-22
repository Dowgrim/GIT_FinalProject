package moteur.trap;

import moteur.entity.Entity;
import moteur.entity.Weakness;

/**
 * Created by user on 22/01/15.
 */
public class WeakeningTrap implements Trap {
    int power;
    public WeakeningTrap(int power){
        this.power=power;
    }
    public void trap(Entity player){
        player.addEffect(new Weakness(power));
    }
}
