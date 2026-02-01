package commands;

import game.Game;
import game.Player;
import items.Item;
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
            return;
        }

        item = player.getInventory().getItem(argument);

        if (item == null) {
            throw new WrongCommandException("Takový předmět nemáš");
        }

        item.use(player);

    }

}
