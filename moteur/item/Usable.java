package moteur.item;

import moteur.entity.Entity;

/**
 * Created by user on 19/01/2015.
 */
public class Usable extends Item{
    private String name;

    public Usable(String desc, String name) {
        super(desc);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void consume(Entity player){
        System.out.println("Ceci n'est pas un objet consommable !");
    }

    public boolean equals(Item item){
        if (this == item){
            return true;
        }
        else if (!(item instanceof Usable)){
            return false;
        }
        else {
            return this.name.equals(((Usable)item).getName());
        }
    }
}
