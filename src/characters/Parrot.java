package characters;

import game.Player;

/**
 * Class represents a parrot which gives advice
 */
public class Parrot extends Character{


    public Parrot(String name, String id) {
        super(name, id);
    }

    /**
     * Prints advice from the parrot
     * @param player the player who is interacting
     */
    @Override
    public void interact(Player player) {

        System.out.println("Pamatuj si že opice má rada ovoce a koza zase sůl, mohlo by se ti to hodit");

    }



}
