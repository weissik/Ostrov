package game;

import items.Item;

import java.util.ArrayList;

/**
 * Class represents an inventory of a player
 */
public class Inventory {

    private final ArrayList<Item> items;
    private final int capacity;

    public Inventory(int capacity) {
        this.capacity = capacity;
        items = new ArrayList<>();
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    /**
     * Adds an item to the inventory
     * @param item added item
     */
    public void addItem(Item item){
        items.add(item);
    }

    /**
     * Removes an item from the inventory
     * @param item removed item
     */
    public void removeItem(Item item){
       items.remove(item);
    }

    /**
     * Finds an item based on id and removes it from the inventory
     * @param id id of the wanted item
     */
    public void removeItemById(String id) {
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getId().equals(id)) {
                items.remove(i);
                return;
            }
        }
    }

    /**
     * Gets an item from the inventory based on its id
     * @param id id of the wanted item
     * @return wnated item if found
     */
    public Item getItem(String id) {
        for (Item item : items){
            if (item.getId().equals(id)) return item;
        }
        return null;
    }

    /**
     * Checks whether the inventory is at max capacity
     * @return boolean whether the inventory is full
     */
    public boolean isFull(){
        return items.size() >= capacity;
    }

    /**
     * Returns a string of all items in the inventory
     * @return string of all items
     */
    public String printItems(){
        StringBuilder sb = new StringBuilder();
        for (Item item : items) sb.append(item.getName()).append(", ");
        sb.delete(sb.length()-2, sb.length());
        return sb.toString();
    }


    /**
     * Prints items in the inventory
     */
    public void getInfo() {
        if (!items.isEmpty()) {
            System.out.println(Colors.paint(Colors.YELLOW, "Inventář: ")+ printItems());
        } else {
            System.out.println(Colors.paint(Colors.YELLOW, "Inventář je prázdný"));
        }
    }

}
