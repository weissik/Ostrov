package characters;

import game.Player;

/**
 * Class represents a goat which blocks one location
 */
public class Goat extends Character{

    public Goat(String name, String id) {
        super(name, id);
    }

    /**
     * Prints that the goat is in a way
     * @param player the player who is interacting
     */
    @Override
    public void interact(Player player) {

        System.out.println("Koza blokuje cestu dál a ignoruje tě");

    }

}
