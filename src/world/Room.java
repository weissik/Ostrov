package world;

import game.Colors;
import game.Dictionary;
import items.Item;
import characters.Character;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * This class represents one room (location) in the game
 */
public class Room {

    private final String id;
    private final String name;
    private final String description;
    private final HashMap<String, Room> exits;
    private final ArrayList<Item> items;
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

    public String getName() {
        return name;
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

    /**
     * Finds an item in the room based on id
     * @param itemId id of the wanted item
     * @return actual wanted item
     */
    public Item getItem(String itemId){
        for (Item item : items){
            if (item.getId().equals(itemId)) return item;
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
        this.blocked = blocked;
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

    /**
     * Returs a String of all items in the room
     * @return String of all items
     */
    public String printItems(){
        StringBuilder sb = new StringBuilder();
        for (Item item : items) sb.append(Colors.paint(Colors.YELLOW, item.getName())).append(" - ").append(item.getDescription()).append("\n");
        return sb.toString();
    }

    /**
     * Returns a String of all possible ways out of the room
     * @return String of all exits
     */
    public String printExits() {
        StringBuilder sb = new StringBuilder();
        for (String key : exits.keySet()) {
            sb.append(Dictionary.translate(key)).append(", ");
        }
        sb.delete(sb.length()-2, sb.length());
        return sb.toString();
    }

}
