package items;

import game.Player;

/**
 * Class represets a campfire used to make light
 */
public class CampFire extends Item{

    public CampFire(String id, String name, String description, boolean portable) {
        super(id, name, description, portable);
    }

    /**
     * Checks whether the player has a stick and lights it to create a torch
     * @param player player using this item
     */
    @Override
    public void use(Player player) {

        if (player.getInventory().getItem("stick") == null) throw new WrongUseException("Nemáš co bys zapálil");

        Stick item = (Stick) player.getInventory().getItem("stick");
        item.setOnFire();
        System.out.println("Zapálil jsi pochodeň");

    }
}
