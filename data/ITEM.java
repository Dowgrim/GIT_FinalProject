package data;

import item.Item;
import item.Key;
import item.Potion;

import java.util.ArrayList;

/**
 * Created by Michael on 21/01/2015.
 */
public abstract class ITEM {

    public static ArrayList<ArrayList<Object>> items = new ArrayList<ArrayList<Object>>();


    public void initialiseParam(){
        ArrayList<Object> obj1 = new ArrayList<Object>();
        obj1.add(20);
        obj1.add(new Item("an useless Item"));
        items.add(obj1);
        ArrayList<Object> obj2 = new ArrayList<Object>();
        obj1.add(20);
        obj1.add(new Key("an useless Potion"));
        items.add(obj2);
    }
}
