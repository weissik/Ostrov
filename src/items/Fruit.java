package items;

import characters.Monkey;
import game.Player;

public class Fruit extends Item{
    public Fruit(String id, String name, String description, boolean portable) {
        super(id, name, description, portable);
    }

    @Override
    public void use(Player player) {

        if (!(player.getCurrentRoom().getCharacter() instanceof Monkey character)) throw new WrongUseException("Ovoce se hodí pro obměkčení opice");

        character.give();
        player.getInventory().removeItemById("fruit");
        player.getInventory().addItem(player.getCurrentRoom().getItem("battery"));
        player.getCurrentRoom().removeItem(player.getCurrentRoom().getItem("battery"));
        System.out.println("Dal jsi opici ovoce, ta si spokojena odesla a ty jsi si vklidu vzal baterii");

    }

}
