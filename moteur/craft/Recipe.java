package moteur.craft;

import moteur.entity.Entity;

/**
 * Created by user on 21/01/2015.
 */
public interface Recipe {
    public boolean canCreate(Entity player);
    public void create(Entity player);
}
