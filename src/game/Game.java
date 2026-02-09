package game;

import commands.CommandParser;
import commands.WrongCommandException;
import items.WrongUseException;
import world.GameData;
import world.Room;
import world.World;
import world.WorldBuilder;

import java.util.Scanner;

public class Game {

    private final World world;
    private final Player player;
    private final CommandParser parser;
    private boolean running;
    private boolean repairMode;

    public Game(World world, Player player, CommandParser parser) {
        this.world = world;
        this.player = player;
        this.parser = parser;
        this.running = false;
        this.repairMode = false;
    }

    public World getWorld() {
        return world;
    }

    public static Game LOAD_GAME(){

        GameData data = GameData.loadGameData("/gameData.json");
        World world = WorldBuilder.buildWorld(data);
        Player player = new Player(world.getStartingRoom(), new Inventory(4));
        CommandParser commandParser = new CommandParser();

        return new Game(world, player, commandParser);

    }

    public void runGame() {
        running = true;
        Scanner sc = new Scanner(System.in);
        do {
            Room room = player.getCurrentRoom();
            String input = sc.nextLine();
            processCommand(input);
            if (player.getCurrentRoom() != room) {
                player.getCurrentRoom().getInfo();
                player.getInventory().getInfo();
            }
        } while (running);

    }

    public void processCommand(String input){
        try {
            parser.parse(input).execute(this, player, world);
        } catch (WrongCommandException | WrongUseException | ArrayIndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }
    }

    public void endGame(){
        running = false;
    }

    public boolean isRunning(){
        return running;
    }

    public void enableRepairMode() {
        repairMode = true;
    }

    public void disableRepairMode() {
        repairMode = false;
    }

    public boolean isInRepairMode(){
        return repairMode;
    }






}
