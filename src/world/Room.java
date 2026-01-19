package world;

import items.Item;

import java.util.ArrayList;
import java.util.HashMap;

public class Room {

    private String name;
    private String description;
    private HashMap<String, Room> exits;
    private ArrayList<Item> items;
    private Character character;
    private boolean blocked;

    public void addExit(String direction, Room room){
    }

    public Room getExit(String name){
    }

    public void addItem(Item item){
    }

    public void removeItem(Item item){
    }

    public boolean isBlocked(){
    }

    public void setBlocked(boolean blocked){
    }

}
