package characters;

import game.Player;

/**
 * Class represents a monkey which prevents the player from taking the battry
 */
public class Monkey extends Character{

    private boolean given;

    public Monkey(String name, String id) {
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
     * Prints info about the monkey
     * @param player the player who is interacting
     */
    @Override
    public void interact(Player player) {

        if (given) {
            System.out.println("Opice si spokojeni ji ovoce a nevšímá si tě.");
        } else {
            System.out.println("Opice tě tiše pozoruje a brání ti v tom vzít si baterii.");
        }

    }

}
