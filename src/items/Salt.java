package items;

import characters.Goat;
import game.Player;

/**
 * Class represents salt used to distract the goat
 */
public class Salt extends Item{

    public Salt(String id, String name, String description, boolean portable) {
        super(id, name, description, portable);
    }

    /**
     * Checks if the player is in correct location to use salt
     * @param player player using this item
     */
    @Override
    public void use(Player player) {

        if (!(player.getCurrentRoom().getCharacter() instanceof Goat character)) throw new WrongUseException("Sůl se hodí pro odlakaní kozy.");

        character.give();
        player.getCurrentRoom().getExit("south").setBlocked(false);
        System.out.println("Pomocí soli jsi odlákal kozu, nyní můžeš jít dál");
    }

}
