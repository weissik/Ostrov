package world;

import com.google.gson.Gson;
import items.Item;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class WorldLoader {

    public ArrayList<Character> characters;
    public ArrayList<Room> rooms;
    public ArrayList<Item> items;

    public static WorldLoader loadGameData(String filePath) {

        Gson gson = new Gson();

        try (InputStream inputStream = WorldLoader.class.getResourceAsStream(filePath)) {

            if (inputStream == null) {
                throw new IllegalStateException("Resource nenalezen: " + filePath);
            }

            return gson.fromJson(new InputStreamReader(inputStream, StandardCharsets.UTF_8), WorldLoader.class);

        } catch (Exception e) {
            throw new RuntimeException("Chyba pri načítání: " + e.getMessage());
        }

    }
}
