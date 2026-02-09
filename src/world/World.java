package world;

import java.util.HashMap;

public class World {

    private HashMap<String, Room> rooms;
    private Room startingRoom;

    public World(HashMap<String, Room> rooms) {
        this.rooms = rooms;
        this.startingRoom = rooms.get("beach");
    }

    public Room getRoom(String id) {
        return rooms.get(id);
    }

    public HashMap<String, Room> getRooms() {
        return rooms;
    }

    public void setRooms(HashMap<String, Room> rooms) {
        this.rooms = rooms;
    }

    public Room getStartingRoom(){
        return startingRoom;
    }

    public void setStartingRoom(Room startingRoom) {
        this.startingRoom = startingRoom;
    }
}
