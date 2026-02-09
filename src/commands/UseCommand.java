package commands;

import game.Game;
import game.Player;
import items.Item;
import items.Radio;
import items.Salt;
import world.World;

public class UseCommand implements ArgumentCommand{

    private String argument;

    public String getArgument() {
        return argument;
    }

    @Override
    public void setArgument(String argument) {
        this.argument = argument;
    }

    @Override
    public void execute(Game game, Player player, World world) {

        Item item = player.getCurrentRoom().getItem(argument);

        if (item != null && !item.isPortable()) {

            item.use(player);
            game.getWorld().getRoom("cave").setBlocked(false);
            return;

        }

        item = player.getInventory().getItem(argument);

        if (item == null) {
            throw new WrongCommandException("Takový předmět nemáš");
        }

        if (item instanceof Salt) {

            item.use(player);
            game.getWorld().getRoom("ruins").setBlocked(false);
            player.getInventory().removeItem(item);

        }

        item.use(player);
        player.getInventory().removeItem(item);

        if (item instanceof Radio radio && radio.isRepaired()) game.endGame();

    }

}
