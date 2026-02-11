package commands;

import game.Game;
import game.Player;
import items.Item;
import world.World;

public class DropCommand implements ArgumentCommand{

    private String argument;

    @Override
    public void setArgument(String argument) {
        this.argument = argument;
    }

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
