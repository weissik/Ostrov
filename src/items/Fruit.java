package items;

import game.Player;

public class Fruit extends Item{
    public Fruit(String id, String name, String description, boolean portable) {
        super(id, name, description, portable);
    }

    @Override
    public void use(Player player) {
    }

}
