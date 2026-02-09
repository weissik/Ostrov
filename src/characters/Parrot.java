package characters;

import game.Player;

public class Parrot extends Character{


    public Parrot(String name, String id) {
        super(name, id);
    }

    @Override
    public void interact(Player player) {

        System.out.println("Pamatuj si ze opice ma rada ovoce a koza zase sul, mohlo by se ti to hodit");

    }



}
