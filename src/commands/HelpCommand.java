package commands;

import game.Game;
import game.Player;
import world.World;

public class HelpCommand implements Command{

    @Override
    public void execute(Game game, Player player, World world) {
        System.out.println("""
                Dostupné příkazy:
                -jdi <směr>         -prozkoumej
                -vezmi <předmět>    -pomoc
                -poloz <předmět>    -napoveda
                -pouzij <předmět>   -konec
                -mluv
                """);
    }

}
