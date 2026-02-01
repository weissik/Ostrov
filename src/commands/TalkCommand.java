package commands;

import characters.Character;
import game.Game;
import game.Player;
import world.World;

public class TalkCommand implements Command{

    @Override
    public void execute(Game game, Player player, World world) {

        Character character = player.getCurrentRoom().getCharacter();

        if (character == null){
            throw new WrongCommandException("Není tu nikdo s kým mluvit");
        }

        character.interact(player);

    }

}
