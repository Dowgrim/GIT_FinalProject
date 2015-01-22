package craft;

import data.Plants;
import entity.Entity;
import item.Item;
import item.Usable;

import java.util.ArrayList;

/**
 * Created by user on 21/01/2015.
 */
public enum AlchemyRecipes implements Recipe {

    HEALTHPOTION(new Usable(Plants.arnica,"Arnica"), new Usable(Plants.acerola,"Acerola")),
    SUPERHEALTHPOTION(new Usable(Plants.arnica,"Arnica"),new Usable(Plants.acerola,"Acerola"), new Usable(Plants.aubepine,"Aubépine")),
    STRENGTHPOTION(new Usable(Plants.echinacee,"Echinacée"),new Usable(Plants.ginseng,"Ginseng"));

    private ArrayList<Item> itemsNeeded = new ArrayList<Item>();

    private AlchemyRecipes(Item... items){
        for(int i=0;i<items.length;++i){
            itemsNeeded.add(items[i]);
        }
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
        player.getBag().add(result);
    }


}

