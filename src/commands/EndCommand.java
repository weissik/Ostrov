package commands;

import game.Game;
import game.Player;
import world.World;

public class EndCommand implements Command{

    @Override
    public void execute(Game game, Player player, World world) {

        game.endGame();

    }

}
