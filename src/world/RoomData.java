package world;

import items.Item;

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

}
