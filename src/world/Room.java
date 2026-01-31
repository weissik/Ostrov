package world;

import items.Item;
import characters.Character;

import java.util.ArrayList;
import java.util.HashMap;

public class Room {

    private String id;
    private String name;
    private String description;
    private HashMap<String, Room> exits;
    private ArrayList<Item> items;
    private Character character;
    private boolean blocked;

    public Room(String id, String name, String description, boolean blocked) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.blocked = blocked;
    }

    public void addExit(String direction, Room room){
        exits.put(direction, room);
    }

    public Room getExit(String name){
    }

    public void addItem(Item item){
        items.add(item);
    }

    public void removeItem(Item item){
    }

    public boolean isBlocked(){
    }

    public void setBlocked(boolean blocked){
    }

    public void setCharacter(Character character) {
        this.character = character;
    }



}
