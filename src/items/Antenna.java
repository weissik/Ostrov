package items;

import game.Player;

public class Antenna extends Item{

    public Antenna(String id, String name, String description, boolean portable) {
        super(id, name, description, portable);
    }

    @Override
    public void use(Player player) {
    }

}
