package commands;

import game.Game;
import game.Player;
import world.World;

/**
 * Class represent a command for a hint in case the player does not know what to do
 */
public class HintCommand implements Command{

    /**
     * Prints a hint
     * @param game whole game
     * @param player the player using this command
     * @param world game world rooms and items
     */
    @Override
    public void execute(Game game, Player player, World world) {
        System.out.println("Zkus prozkoumat okolí nebo si promluvit s postavami");
    }

}
