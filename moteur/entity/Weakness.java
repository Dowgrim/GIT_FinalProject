package moteur.entity;

import java.util.HashMap;

/**
 * Created by user on 22/01/15.
 */
public class Weakness extends Effect {
    private static final String KEY = "Affaiblissement";

    public Weakness(int power) {
        super(power);
    }

    @Override
    public void apply(Entity player) {}
}
