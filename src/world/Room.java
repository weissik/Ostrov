package world;

import game.Dictionary;
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
        exits = new HashMap<>();
        items = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public void addExit(String direction, Room room){
        exits.put(direction, room);
    }

    public Room getExit(String direction){
        return exits.get(direction);
    }

    public void addItem(Item item){
        items.add(item);
    }

    public Item getItem(String itemName){
        for (Item item : items){
            if (item.getId().equals(itemName)) return item;
        }
        return null;
    }

    public void removeItem(Item item){
        items.remove(item);
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public boolean isBlocked(){
        return blocked;
    }

    public void setBlocked(boolean blocked){
    }

    public Character getCharacter() {
        return character;
    }

    public void setCharacter(Character character) {
        this.character = character;
    }

    public String getDescription() {
        return description;
    }

    public String printItems(){
        StringBuilder sb = new StringBuilder();
        for (Item item : items) sb.append(item.getName()).append(", ");
        sb.delete(sb.length()-2, sb.length());
        return sb.toString();
    }

    public String printExits() {
        StringBuilder sb = new StringBuilder();
        for (String key : exits.keySet()) {
            sb.append(Dictionary.translate(key)).append(", ");
        }
        sb.delete(sb.length()-2, sb.length());
        return sb.toString();
    }

    public void getInfo() {
        System.out.println("-- " + name + " --");
        System.out.println("Cesty: " + printExits());
    }
}
