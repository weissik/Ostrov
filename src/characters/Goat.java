package characters;

import game.Player;

/**
 * Class represents a goat which blocks one location
 */
public class Goat extends Character{

    private boolean given;

    public Goat(String name, String id) {
        super(name, id);
        this.given = false;
    }

    public void give(){
        given = true;
    }



    /**
     * Prints that the goat is in a way
     * @param player the player who is interacting
     */
    @Override
    public void interact(Player player) {

        if (given) {
            System.out.println("Koza si spokojene pochutnává na soli a ty už máš volnou cestu dál.");
        } else {
            System.out.println("Koza blokuje cestu dál a ignoruje tě");
        }

    }

}
