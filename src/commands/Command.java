package commands;

import game.Game;
import game.Player;
import world.World;

/**
 * Iterface for all commands
 */
public interface Command {

    void execute(Game game, Player player, World world);

}
