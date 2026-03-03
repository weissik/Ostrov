package characters;

import game.Player;

/**
 * Class represents a native which can trade with the player or give him advice
 */
public class Native extends Character{

    private boolean given;

    public Native(String name, String id) {
        super(name, id);
        this.given = false;
    }

    /**
     * Sets given to true
     */
    public void give() {
        given = true;
    }

    public boolean isGiven() {
        return given;
    }

    /**
     * Prints advices from the native
     * @param player the player who is interacting
     */
    @Override
    public void interact(Player player) {

        if (!given) {
            System.out.println("Měl bych pro tebe provázek, který by se ti mohl hodit, ale chci za něj nějakou kůži");
        } else {
            System.out.println("Za jeskyní je vrchol hory odtamtud by šel dobře vyslat signál");
        }

    }

}
