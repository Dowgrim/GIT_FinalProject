package moteur.craft;

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
        System.out.println("Bienvenue au laboratoire d'alchimie ! Que voulez vous créer ?");
        System.out.println(Recipes.alchemyRecipes);
        System.out.println((alchemy.size()+1) + ". Quitter le laboratoire d'Alchimie");
        Scanner scan = new Scanner(System.in);
        int choice = scan.nextInt();
        while (wantToCraft){
            if (choice == (alchemy.size()+1)){
                System.out.println("Vous quittez le labo d'alchimie");
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
