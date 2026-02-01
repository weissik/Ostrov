package commands;

import game.Game;
import game.Player;
import world.World;

public class ExploreCommand implements Command{

    @Override
    public void execute(Game game, Player player, World world) {

        System.out.println(player.getCurrentRoom().getDescription());

        if (!player.getCurrentRoom().getItems().isEmpty()) {
            System.out.println("Předměty: " + player.getCurrentRoom().printItems());
        }

        if (player.getCurrentRoom().getCharacter() != null) {
            System.out.println("Postava: " + player.getCurrentRoom().getCharacter().getName());
        }

    }

}
