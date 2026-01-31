package items;

import game.Player;

public class Salt extends Item{

    public Salt(String id, String name, String description, boolean portable) {
        super(id, name, description, portable);
    }

    @Override
    public void use(Player player) {
    }

}
