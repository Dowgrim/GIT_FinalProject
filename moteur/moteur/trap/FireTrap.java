package moteur.trap;

import moteur.entity.Entity;

/**
 * Created by user on 20/01/2015.
 */
public class FireTrap implements Trap {
    public FireTrap(){}
    public void trap(Entity player){
        player.decreaseEnergy(15);
    }
}
