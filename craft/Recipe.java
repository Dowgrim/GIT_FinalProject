package craft;

import data.Plants;
import entity.Entity;
import item.Item;
import item.Usable;

import java.util.ArrayList;

/**
 * Created by user on 20/01/2015.
 */
public enum Recipe {

    HEALTHPOTION(new Usable(Plants.arnica,"Arnica"), new Usable(Plants.acerola,"Acerola")),
    SUPERHEALTHPOTION(new Usable(Plants.arnica,"Arnica"),new Usable(Plants.acerola,"Acerola"), new Usable(Plants.aubepine,"Aubépine")),
    STRENGTHPOTION(),
    AXE();

    private ArrayList<Item> itemsNeeded = new ArrayList<Item>();

    private Recipe(Item... items){
        for(int i=0;i<items.length;++i){
            itemsNeeded.add(items[i]);
        }
    }

    public void create(Entity player){

    }


}
