package characters;

import game.Player;
import world.Room;

public abstract class Character {

    protected String id;
    protected String name;

    public abstract void interact(Player player);

    public Character(String name, String id) {
        this.name = name;
        this.id = id;
    }
}
