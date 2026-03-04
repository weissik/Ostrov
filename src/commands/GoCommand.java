package commands;

import game.Game;
import game.Player;
import world.Room;
import world.World;

/**
 * Class represents a command for moving on the map
 */
public class GoCommand implements ArgumentCommand{

    private String argument;

    @Override
    public void setArgument(String argument) {
        this.argument = argument;
    }

    /**
     * Checks if argument is a real direction where the player can go and moves the player there
     * @param game whole game
     * @param player the player using this command
     * @param world game world rooms and items
     */
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
            if (player.getCurrentRoom().getId().equals("waterfall")) {
                throw new WrongCommandException("V cestě dál ti stojí koza.");
            } else {
                throw new WrongCommandException("V jeskyni je příliš velké tma, bylo by nebezpečné jít tam bez světla.");
            }

        }

        player.moveTo(nextRoom);
    }

}
