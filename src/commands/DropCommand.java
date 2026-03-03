package commands;

import game.Game;
import game.Player;
import items.Item;
import world.World;

/**
 * Class represents a command used for dropping items
 */
public class DropCommand implements ArgumentCommand{

    private String argument;

    @Override
    public void setArgument(String argument) {
        this.argument = argument;
    }

    /**
     * Checks whether the player has the item adn drops it in the current room
     * @param game whole game
     * @param player the player using this command
     * @param world game world rooms and items
     */
    @Override
    public void execute(Game game, Player player, World world) {

        if (argument == null) {
            throw new WrongCommandException("Neznámý předmět");
        }

        Item item = player.getInventory().getItem(argument);

        if (item == null) {
            throw new WrongCommandException("Předmět není v inventáři");
        }

        player.getInventory().removeItem(item);
        player.getCurrentRoom().addItem(item);
        System.out.println("Uspěšně si položil předmět");

    }

}
