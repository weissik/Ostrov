package items;

import game.Player;

public class Battery extends Item{

    public Battery(String id, String name, String description, boolean portable) {
        super(id, name, description, portable);
    }

    @Override
    public void use(Player player) {
    }

}
