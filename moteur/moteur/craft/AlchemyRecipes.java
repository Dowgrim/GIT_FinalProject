package moteur.craft;

import moteur.data.Plants;
import moteur.data.Potions;
import moteur.data.UsableNames;
import moteur.entity.Entity;
import moteur.item.HealthPotion;
import moteur.item.Item;
import moteur.item.Usable;

import java.util.ArrayList;

/**
 * Created by user on 21/01/2015.
 */
public enum AlchemyRecipes implements Recipe {

    HEALTHPOTION(new Usable(Plants.arnica, UsableNames.arnica), new Usable(Plants.acerola,UsableNames.acerola),
            new HealthPotion(Potions.healthPotion,50)),
    SUPERHEALTHPOTION(new Usable(Plants.arnica,UsableNames.arnica),new Usable(Plants.acerola,UsableNames.acerola),
            new Usable(Plants.aubepine,UsableNames.aubepine), new HealthPotion(Potions.superHealthPotion,100));

    private ArrayList<Item> itemsNeeded = new ArrayList<Item>();
    private Item result;

    private AlchemyRecipes(Item... items){
        for(int i=0;i<items.length-1;++i){
            itemsNeeded.add(items[i]);
        }
        result = items[items.length-1];
    }

    public boolean canCreate(Entity player){
        for (Item item :itemsNeeded){
            if (!(player.getBag().contains(item))){
                return false;
            }
        }
        return true;
    }

    public void create(Entity player){
        for (Item component : itemsNeeded){
            player.getBag().remove(component);
        }
    }
}

