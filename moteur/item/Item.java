package moteur.item;

import moteur.entity.Entity;

/**
 * Created by Michael on 19/01/2015.
 */
public class Item {
    public String description;

    public Item(String desc) {
        this.description = desc;
    }

    public String getDescription () {
        return this.description;
    }

    public void consume(Entity player){};
}
