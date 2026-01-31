package world;

import java.util.ArrayList;
import java.util.HashMap;

public class RoomData {

    private String id;
    private String name;
    private String description;
    private HashMap<String, String> exits;
    private ArrayList<String> items;
    private String character;
    private boolean blocked;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public HashMap<String, String> getExits() {
        return exits;
    }

    public ArrayList<String> getItems() {
        return items;
    }

    public String getCharacter() {
        return character;
    }

    public boolean isBlocked() {
        return blocked;
    }
}
