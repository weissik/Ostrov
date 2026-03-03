package commands;

import characters.Character;
import game.Game;
import game.Player;
import world.World;

/**
 * Class represents a command for interaction with characters
 */
public class TalkCommand implements Command{

    /**
     * Checks whether there is a character in the current room and interacts with it
     * @param game whole game
     * @param player the player using this command
     * @param world game world rooms and items
     */
    @Override
    public void execute(Game game, Player player, World world) {

        Character character = player.getCurrentRoom().getCharacter();

        if (character == null){
            throw new WrongCommandException("Není tu nikdo s kým mluvit");
        }

        character.interact(player);

    }

}
