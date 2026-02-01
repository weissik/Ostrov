package commands;

import game.Game;
import game.Player;
import world.Room;
import world.World;

public class GoCommand implements ArgumentCommand{

    private String argument;

    @Override
    public void setArgument(String argument) {
        this.argument = argument;
    }

    @Override
    public void execute(Game game, Player player, World world) {

        if (argument == null){
            throw new WrongCommandException("Neznámý směr");
        }

        Room currentRoom = player.getCurrentRoom();
        Room nextRoom = currentRoom.getExit(argument);

        if (nextRoom == null){
            throw new WrongCommandException("Tímto směrem nelze jít");
        }

        if (nextRoom.isBlocked()){
            throw new WrongCommandException("Aktuálně nelze jít dál, cesta je zablokovaná");
        }

        player.moveTo(nextRoom);
    }

}
