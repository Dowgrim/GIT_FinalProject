package moteur.craft;

import moteur.data.ForgeComponents;
import moteur.data.ForgeItems;
import moteur.data.UsableNames;
import moteur.entity.Entity;
import moteur.item.FightingItem;
import moteur.item.Item;
import moteur.item.Usable;

import java.util.ArrayList;

/**
 * Created by user on 22/01/2015.
 */
public enum ForgeRecipes implements Recipe {

    TORCH(new Usable(ForgeComponents.coal,UsableNames.coal),new Usable(ForgeComponents.wood,UsableNames.wood),
            new Usable(ForgeItems.torch,UsableNames.torch)),
    AXE(new Usable(ForgeComponents.wood,UsableNames.wood),new Usable(ForgeComponents.blade,UsableNames.blade),
            new Usable(ForgeItems.axe,UsableNames.axe)),
    IRONSWORD(new Usable(ForgeComponents.ironOre,UsableNames.ironOre),new Usable(ForgeComponents.ironOre,UsableNames.ironOre),
            new FightingItem(ForgeItems.ironSword,UsableNames.ironSword,1)),
    MITHRILSWORD(new Usable(ForgeComponents.mithrilOre, UsableNames.mithrilOre),new Usable(ForgeComponents.mithrilOre,UsableNames.mithrilOre),
            new FightingItem(ForgeItems.mithrilSword,UsableNames.mithrilSword,2)),
    CELESTIALSWORD(new Usable(ForgeComponents.celestialOre,UsableNames.celestialOre),new Usable(ForgeComponents.celestialOre,UsableNames.celestialOre),
            new FightingItem(ForgeItems.celestialSword,UsableNames.celestialSword,4));


    private ArrayList<Item> itemsNeeded = new ArrayList<Item>();
    private Item result;

    private ForgeRecipes(Item... items){
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
