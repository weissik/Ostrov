package items;

import game.Player;

public class Table extends Item{
    public Table(String id, String name, String description, boolean portable) {
        super(id, name, description, portable);
    }

    @Override
    public void use(Player player) {

    }
}
