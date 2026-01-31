package world;

import characters.*;
import characters.Character;
import items.*;


import java.util.HashMap;
import java.util.Map;

public class WorldBuilder {

    public static World buildWorld(GameData gameData){

        HashMap<String, Character> characterMap = new HashMap<>();

        for (CharacterData data : gameData.getCharacters()){
            Character character;
            switch(data.getType()) {
                case "Parrot":
                    character = new Parrot(data.getId(), data.getName());
                    break;
                case "Native":
                    character = new Native(data.getId(), data.getName());
                    break;
                case "Monkey":
                    character = new Monkey(data.getId(), data.getName());
                    break;
                case "Goat":
                    character = new Goat(data.getId(), data.getName());
                    break;
                default:
                    throw new IllegalStateException("Neznámý typ postavy.");
            }
            characterMap.put(data.getId(), character);
        }

        HashMap<String, Item> itemMap = new HashMap<>();

        for (ItemData data : gameData.getItems()){
            Item item;
            switch (data.getType()){
                case "Radio":
                    item = new Radio(data.getId(), data.getName(), data.getDescription(), data.isPortable());
                    break;
                case "Antenna":
                    item = new Antenna(data.getId(), data.getName(), data.getDescription(), data.isPortable());
                    break;
                case "Battery":
                    item = new Battery(data.getId(), data.getName(), data.getDescription(), data.isPortable());
                    break;
                case "Tape":
                    item = new Tape(data.getId(), data.getName(), data.getDescription(), data.isPortable());
                    break;
                case "Leather":
                    item = new Leather(data.getId(), data.getName(), data.getDescription(), data.isPortable());
                    break;
                case "Stick":
                    item = new Stick(data.getId(), data.getName(), data.getDescription(), data.isPortable());
                    break;
                case "Fruit":
                    item = new Fruit(data.getId(), data.getName(), data.getDescription(), data.isPortable());
                    break;
                case "Salt":
                    item = new Salt(data.getId(), data.getName(), data.getDescription(), data.isPortable());
                    break;
                case "CampFire":
                    item = new CampFire(data.getId(), data.getName(), data.getDescription(), data.isPortable());
                    break;
                case "Table":
                    item = new Table(data.getId(), data.getName(), data.getDescription(), data.isPortable());
                    break;
                default:
                    throw new IllegalStateException("Neznámý typ předmětu.");
            }
            itemMap.put(data.getId(), item);
        }

        HashMap<String, Room> roomMap = new HashMap<>();

        for (RoomData data : gameData.getRooms()) {
            Room room = new Room(data.getId(), data.getName(), data.getDescription(), data.isBlocked());
            roomMap.put(data.getId(), room);
        }
        for (RoomData data : gameData.getRooms()){
            Room room = roomMap.get(data.getId());
            for(Map.Entry<String, String> exit : data.getExits().entrySet()){
                Room target = roomMap.get(exit.getValue());
                room.addExit(exit.getKey(), target);
            }
        }
        for (RoomData data : gameData.getRooms()){
            if (data.getCharacter() != null){
                Room room = roomMap.get(data.getId());
                room.setCharacter(characterMap.get(data.getCharacter()));
            }
        }
        for (RoomData data : gameData.getRooms()){
            Room room = roomMap.get(data.getId());
            if (data.getItems() != null) {
                for (String item : data.getItems()){
                    room.addItem(itemMap.get(item));
                }
            }
        }

        World world = new World(roomMap);
        return world;
    }

}
