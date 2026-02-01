package characters;

import game.Player;
import world.Room;

public abstract class Character {

    protected String id;
    protected String name;

    public abstract void interact(Player player);

    public Character(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
