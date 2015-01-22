package moteur.craft;

import moteur.data.DialogCraft;
import moteur.data.Recipes;
import moteur.entity.Entity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.EnumSet;
import java.util.Scanner;

/**
 * Created by user on 20/01/2015.
 */
public class AlchemyLab implements Crafter{

    private ArrayList<AlchemyRecipes> alchemy = new ArrayList<AlchemyRecipes>();

    public AlchemyLab() {
        ArrayList<AlchemyRecipes> alchemy =new ArrayList<AlchemyRecipes>(Arrays.asList(AlchemyRecipes.values()));
    }
    public void craft(Entity player){
        boolean wantToCraft = true;
        System.out.println(DialogCraft.welcomeAlchemy);
        System.out.println(Recipes.alchemyRecipes);
        System.out.println((alchemy.size()+1) +DialogCraft.quit);
        Scanner scan = new Scanner(System.in);
        int choice = scan.nextInt();
        while (wantToCraft){
            if (choice == (alchemy.size()+1)){
                wantToCraft = false;
            }
            else {
                if (alchemy.get(choice-1).canCreate(player)){
                    alchemy.get(choice-1).create(player);
                }
            }
        }
    }
}
