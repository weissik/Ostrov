package items;

import game.Player;

/**
 * Class represents a tape used to repair the radio
 */
public class Tape extends Item{

    public Tape(String id, String name, String description, boolean portable) {
        super(id, name, description, portable);
    }

    /**
     * Check wheter the player has radio and uses the tape to repair it
     * @param player player using this item
     */
    @Override
    public void use(Player player) {

        if (player.getRadio() == null) throw new WrongUseException("Bez vysílačky je ti provazek na nic");

        player.getRadio().repairStep();
        System.out.println("Uspěšně jsi upevnil vysílačku");

    }

}
