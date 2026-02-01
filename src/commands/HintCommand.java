package commands;

import game.Game;
import game.Player;
import world.World;

public class HintCommand implements Command{

    @Override
    public void execute(Game game, Player player, World world) {
        System.out.println("Zkus prozkoumat okolí nebo si promluvit s postavami");
    }

}
