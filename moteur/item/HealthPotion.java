package moteur.item;


import moteur.entity.Entity;

/**
 * Created by user on 22/01/2015.
 */
public class HealthPotion extends Item {
    int energyRestoration;
    public HealthPotion(String desc, int energyRestoration) {
        super(desc);
        this.energyRestoration=energyRestoration;
    }

    public void consume(Entity player){
        System.out.println("Vous gagnez "+energyRestoration+" points de vie");
        player.increaseEnergy(energyRestoration);
    }
}
