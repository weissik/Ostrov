package items;

import game.Player;

public abstract class Item {

    protected String id;
    protected String name;
    protected String description;
    protected boolean portable;

    public abstract void use(Player player);

    public boolean isPortable(){
    }

}
