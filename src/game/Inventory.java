package game;

import items.Item;

import java.util.ArrayList;

public class Inventory {

    private ArrayList<Item> items;
    private int capacity;

    public Inventory(int capacity) {
        this.capacity = capacity;
        items = new ArrayList<>();
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public void addItem(Item item){
        items.add(item);
    }

    public void removeItem(Item item){
       items.remove(item);
    }

    public Item getItem(String itemName) {
        for (Item item : items){
            if (item.getId().equals(itemName)) return item;
        }
        return null;
    }

    public boolean isFull(){
        return items.size() >= capacity;
    }

    public String printItems(){
        StringBuilder sb = new StringBuilder();
        for (Item item : items) sb.append(item.getName()).append(", ");
        sb.delete(sb.length()-2, sb.length());
        return sb.toString();
    }

}
