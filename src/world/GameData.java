package world;

import com.google.gson.Gson;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class GameData {

    public ArrayList<CharacterData> characters;
    public ArrayList<RoomData> rooms;
    public ArrayList<ItemData> items;

    public static GameData loadGameData(String filePath) {

        Gson gson = new Gson();

        try (InputStream inputStream = GameData.class.getResourceAsStream(filePath)) {

            if (inputStream == null) {
                throw new IllegalStateException("Resource nenalezen: " + filePath);
            }

            return gson.fromJson(new InputStreamReader(inputStream, StandardCharsets.UTF_8), GameData.class);

        } catch (Exception e) {
            throw new RuntimeException("Chyba pri načítání: " + e.getMessage());
        }

    }
}
