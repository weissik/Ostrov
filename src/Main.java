import commands.CommandParser;
import commands.WrongCommandException;
import game.Game;
import game.Inventory;
import game.Player;
import world.GameData;
import world.World;
import world.WorldBuilder;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        GameData data = GameData.loadGameData("/gameData.json");
        World world = WorldBuilder.buildWorld(data);
        Player player = new Player(world.getStartingRoom(), new Inventory(4));
        CommandParser cp = new CommandParser();
        Game game = new Game(world, player, cp);
        while (true) {
            Scanner sc = new Scanner(System.in);
            String input = sc.nextLine();
            try {
                cp.parse(input).execute(game, player, world);
            } catch (WrongCommandException e) {
                System.out.println(e.getMessage());
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println(e.getMessage());
            }
        }


    }
}