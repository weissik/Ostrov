package game;

import commands.CommandParser;
import commands.WrongCommandException;
import items.WrongUseException;
import world.GameData;
import world.Room;
import world.World;
import world.WorldBuilder;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Class represents the whole game with all features
 */
public class Game {

    private final World world;
    private final Player player;
    private final CommandParser parser;
    private boolean running;
    private boolean won;
    private final ArrayList<String> commands;

    public Game(World world, Player player, CommandParser parser) {
        this.world = world;
        this.player = player;
        this.parser = parser;
        this.running = false;
        this.won = false;
        commands = new ArrayList<>();
        commands.add("jdi <směr>");
        commands.add("vezmi <předmět>");
        commands.add("poloz <předmět>");
        commands.add("pouzij <předmět>");
        commands.add("mluv");
        commands.add("prozkoumej");
        commands.add("pomoc");
        commands.add("napoveda");
        commands.add("konec");
    }

    public World getWorld() {
        return world;
    }

    /**
     * Sets win to true
     */
    public void win() {
        this.won = true;
    }

    /**
     * Loads game from a file
     * @return Game object filled with all data
     */
    public static Game LOAD_GAME(){

        GameData data = GameData.loadGameData("/gameData.json");
        World world = WorldBuilder.buildWorld(data);
        Player player = new Player(world.getStartingRoom(), new Inventory(2));
        CommandParser commandParser = new CommandParser();

        return new Game(world, player, commandParser);

    }

    /**
     * Runs game loop
     */
    public void runGame() {
        introductoryText();
        running = true;
        Scanner sc = new Scanner(System.in);
        System.out.println(Colors.paint(Colors.GREEN, "\nPokračovat >>"));
        sc.nextLine();
        printCommands();
        System.out.println("\nSeznam lze kdykoli zobrazit příkazem pomoc");
        System.out.println(Colors.paint(Colors.GREEN, "\nZačít hru >>"));
        sc.nextLine();
        info();
        do {
            Room room = player.getCurrentRoom();
            System.out.println("\n" + Colors.paint(Colors.GREEN, "Zadej příkaz >>"));
            String input = sc.nextLine();
            processCommand(input);
            if (player.getCurrentRoom() != room) {
                System.out.println("\n\n");
                info();
            }
        } while (running);

    }

    /**
     * Process a command from user input
     * @param input user input
     */
    public void processCommand(String input){
        try {
            parser.parse(input).execute(this, player, world);
        } catch (WrongCommandException | WrongUseException | ArrayIndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Ends game and prints all info
     */
    public void endGame(){
        running = false;
        if (won){
            try {
                InputStream inputStream = getClass().getClassLoader().getResourceAsStream("ending.txt");
                BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
                String line;
                while((line = br.readLine()) != null){
                    System.out.println(line);
                }
            } catch (IOException e) {
                System.out.println("Chyba při načítání zavěrečného souboru");
            }
            System.out.println(Colors.paint(Colors.GREEN, "Gratuluji, vyhrál jsi!"));
        } else {
            System.out.println("\nKONEC HRY\n" + Colors.paint(Colors.RED, "Hra byla ukončena bez vítezství"));
        }
    }

    /**
     * Prints text for introduction
     */
    public void introductoryText() {

        try {
            InputStream inputStream = getClass().getClassLoader().getResourceAsStream("introduction.txt");
            BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
            String line;
            while((line = br.readLine()) != null){
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Chyba při načítání úvodního souboru");
        }

    }

    /**
     * Prints all info for the game loop
     */
    public void info() {
        System.out.println("=== " + Colors.paint(Colors.RED, player.getCurrentRoom().getName()) + " ===" );
        System.out.println(player.getCurrentRoom().getDescription());
        System.out.println(Colors.paint(Colors.CYAN, "Cesty: ") + player.getCurrentRoom().printExits());
        if (player.getCurrentRoom().getCharacter() != null) System.out.println(Colors.paint(Colors.CYAN, "Postava: ") + player.getCurrentRoom().getCharacter().getName());
        player.getInventory().getInfo();
    }

    /**
     * Prints a list of all possible command to use
     */
    public void printCommands(){
        System.out.println(Colors.paint(Colors.CYAN, "\nDostupné příkazy:"));
        for (String command : commands) System.out.println(command);
    }







}
