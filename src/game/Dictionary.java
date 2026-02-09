package game;

import java.util.HashMap;

public class Dictionary {

    public static HashMap<String, String> dictionary = new HashMap<>();

    static {
        dictionary.put("sever", "north");
        dictionary.put("jih", "south");
        dictionary.put("zapad", "west");
        dictionary.put("vychod", "east");
        dictionary.put("vysilacka", "radio");
        dictionary.put("antena", "antenna");
        dictionary.put("baterie", "battery");
        dictionary.put("provazek", "tape");
        dictionary.put("kousek kuze", "leather");
        dictionary.put("klacek", "stick");
        dictionary.put("sul", "salt");
        dictionary.put("ovoce", "fruit");
        dictionary.put("stul", "table");
        dictionary.put("ohniste", "campfire");
        dictionary.put("north", "sever");
        dictionary.put("south", "jih");
        dictionary.put("west", "zapad");
        dictionary.put("east", "vychod");

    }

    public static String translate(String string) {
        return dictionary.get(string);

    }


}
