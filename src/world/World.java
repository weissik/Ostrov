package world;

import java.util.HashMap;

public class World {

    private final HashMap<String, Room> rooms;
    private final Room startingRoom;

    public World(HashMap<String, Room> rooms) {
        this.rooms = rooms;
        this.startingRoom = rooms.get("beach");
    }

    public Room getRoom(String id) {
        return rooms.get(id);
    }

    public Room getStartingRoom(){
        return startingRoom;
    }

}
