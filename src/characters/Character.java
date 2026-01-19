package characters;

import game.Player;
import world.Room;

public abstract class Character {

    protected String name;
    protected Room room;

    public abstract void interact(Player player);

}
