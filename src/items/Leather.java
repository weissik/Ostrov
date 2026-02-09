package items;

import characters.Native;
import game.Player;

public class Leather extends Item{

    public Leather(String id, String name, String description, boolean portable) {
        super(id, name, description, portable);
    }

    @Override
    public void use(Player player) {

        if (!(player.getCurrentRoom().getCharacter() instanceof Native character)) throw new WrongUseException("Kůži lze vyměnit s domorodcem");

        character.give();
        player.getInventory().removeItemById("leather");
        player.getInventory().addItem(player.getCurrentRoom().getItem("tape"));
        player.getCurrentRoom().removeItem(player.getCurrentRoom().getItem("tape"));
        System.out.println("Dal jsi domorodci kousek kouže a on ti za to dal provázek");

    }

}
