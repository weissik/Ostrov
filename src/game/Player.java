package game;

import items.Item;
import items.Radio;
import world.Room;

/**
 * Class represents a player
 */
public class Player {

    private Room  currentRoom;
    private final Inventory inventory;



    public Player(Room currentRoom, Inventory inventory) {
        this.currentRoom = currentRoom;
        this.inventory = inventory;
    }

    /**
     * Looks for radio in players inventory
     * @return Radio if found
     */
    public Radio getRadio() {
        for (Item item : inventory.getItems()) {
            if (item.getId().equals("radio")) return (Radio) item;
        }
        return null;
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public Inventory getInventory() {
        return inventory;
    }

    /**
     * Moves player to a different room
     * @param room new location
     */
    public void moveTo(Room room){
        currentRoom = room;
    }

}
