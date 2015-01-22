package moteur.entity;

/**
 * Created by user on 22/01/15.
 */
public class Weakness implements Effect {
    private int power;
    public Weakness(int power) {
        this.power = power;
    }

    /**
     * This effect makes the player weaker
     * @param player
     */
    public void apply(Entity player) {
        player.setWeakness(player.getWeakness() + power);
    }
}
