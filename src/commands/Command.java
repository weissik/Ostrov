package commands;

import game.Game;
import game.Player;
import world.World;

public interface Command {

    void execute(Game game, Player player, World world);

}
