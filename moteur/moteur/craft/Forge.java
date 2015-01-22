package moteur.craft;

import moteur.data.DialogCraft;
import moteur.data.Recipes;
import moteur.entity.Entity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by user on 20/01/2015.
 */
public class Forge implements Crafter {
    private ArrayList<ForgeRecipes> forge = new ArrayList<ForgeRecipes>();

    public Forge() {
        ArrayList<ForgeRecipes> forge =new ArrayList<ForgeRecipes>(Arrays.asList(ForgeRecipes.values()));
    }
    public void craft(Entity player){
        boolean wantToCraft = true;
        System.out.println(DialogCraft.welcomeForge);
        System.out.println(Recipes.forgeRecipes);
        System.out.println((forge.size()+1) + DialogCraft.quit);
        Scanner scan = new Scanner(System.in);
        int choice = scan.nextInt();
        while (wantToCraft){
            if (choice == (forge.size()+1)){
                wantToCraft = false;
            }
            else {
                if (forge.get(choice-1).canCreate(player)){
                    forge.get(choice - 1).create(player);
                }
            }
        }
    }
}
