package items;

import game.Player;

public class Stick extends Item{

    public Stick(String id, String name, String description, boolean portable) {
        super(id, name, description, portable);
    }

    @Override
    public void use(Player player) {
    }

}

