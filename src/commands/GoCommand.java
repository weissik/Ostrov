package commands;

import game.Player;
import world.World;

public class GoCommand implements Command{

    private String argument;

    public String getArgument() {
        return argument;
    }

    public void setArgument(String argument) {
        this.argument = argument;
    }

    @Override
    public void execute(Player player, World world) {
    }

}
