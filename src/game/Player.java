package game;

import world.Room;

public class Player {

    private Room  currentRoom;
    private Inventory inventory;

    public Player(Room currentRoom, Inventory inventory) {
        this.currentRoom = currentRoom;
        this.inventory = inventory;
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public void setCurrentRoom(Room currentRoom) {
        this.currentRoom = currentRoom;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void moveTo(Room room){
        currentRoom = room;
    }

}
