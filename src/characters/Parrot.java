package characters;

import game.Player;

public class Parrot extends Character{


    public Parrot(String name, String id) {
        super(name, id);
    }

    @Override
    public void interact(Player player) {

        System.out.println("Pamatuj si že opice má rada ovoce a koza zase sůl, mohlo by se ti to hodit");

    }



}
