package commands;

import game.Game;
import game.Player;
import world.World;

/**
 * Class represents a command for printing all possible commands
 */
public class HelpCommand implements Command{

    /**
     * Prints all possible commands in the game
     * @param game whole game
     * @param player the player using this command
     * @param world game world rooms and items
     */
    @Override
    public void execute(Game game, Player player, World world) {

        game.printCommands();

    }

}
