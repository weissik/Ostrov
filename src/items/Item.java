package items;

import game.Player;

public abstract class Item {

    protected String id;
    protected String name;
    protected String description;
    protected boolean portable;

    public Item(String id, String name, String description, boolean portable) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.portable = portable;
    }

    public abstract void use(Player player);

    public boolean isPortable(){
    }



}
