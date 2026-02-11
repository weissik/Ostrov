package commands;

import game.Colors;
import game.Game;
import game.Player;
import world.World;

public class ExploreCommand implements Command{

    @Override
    public void execute(Game game, Player player, World world) {

        if (!player.getCurrentRoom().getItems().isEmpty()) {
            System.out.println(Colors.paint(Colors.CYAN, "\nPředměty:\n") + player.getCurrentRoom().printItems());
        }

        if (player.getCurrentRoom().getCharacter() != null) {
            System.out.println(Colors.paint(Colors.CYAN, "Postava: ") + player.getCurrentRoom().getCharacter().getName());
        }

        if (player.getCurrentRoom().getItems().isEmpty() && player.getCurrentRoom().getCharacter() == null) {
            System.out.println(Colors.paint(Colors.CYAN, "Místnost je prázdná"));
        }

    }

}
