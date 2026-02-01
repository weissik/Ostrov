package game;

import commands.CommandParser;
import world.World;

public class Game {

    private World world;
    private Player player;
    private CommandParser parser;
    private boolean running;

    public Game(World world, Player player, CommandParser parser) {
        this.world = world;
        this.player = player;
        this.parser = parser;
        this.running = false;
    }

    public void start(){
    }

    public void processCommand(String input){
    }

    public void endGame(){
        running = false;
    }

    public boolean isRunning(){
        return running;
    }





}
