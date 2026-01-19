package commands;

import game.Player;
import world.World;

public interface Command {

    void execute(Player player, World world);

}
