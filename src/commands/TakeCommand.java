package commands;

import characters.Monkey;
import characters.Native;
import game.Game;
import game.Player;
import items.Item;
import world.World;

/**
 * Class represents a command for taking items
 */
public class TakeCommand implements ArgumentCommand{

    private String argument;

    @Override
    public void setArgument(String argument) {
        this.argument = argument;
    }

    /**
     * Checks whether the argument is a real item that can be taken and
     * if the player has full inventory then adds it to the players inventory
     * @param game whole game
     * @param player the player using this command
     * @param world game world rooms and items
     */
    @Override
    public void execute(Game game, Player player, World world) {

        Item item = player.getCurrentRoom().getItem(argument);

        if (item == null) {
            throw new WrongCommandException("Předmět není v místnosti");
        }

        if (!item.isPortable()){
            throw new WrongCommandException("Předmět nelze sebrat");
        }

        if (item.getId().equals("tape")) {
            Native character = (Native) player.getCurrentRoom().getCharacter();
            if (!character.isGiven()) {
                throw new WrongCommandException("Provázek patří domorodci, nemůžeš si ho jen tak vzít");
            }
        }

        if (item.getId().equals("battery")) {
            Monkey character = (Monkey) player.getCurrentRoom().getCharacter();
            if (!character.isGiven()) {
                throw new WrongCommandException("Opice si baterii střeží a nepustí tě k ní");
            }
        }

        if (player.getInventory().isFull()){
            throw new WrongCommandException("Inventář je plný");
        }

        player.getCurrentRoom().removeItem(item);
        player.getInventory().addItem(item);
        System.out.println("Sebral jsi předmět");

    }

}
