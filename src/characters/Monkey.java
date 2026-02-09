package characters;

import game.Player;

public class Monkey extends Character{

    private boolean given;

    public Monkey(String name, String id) {
        super(name, id);
        this.given = false;
    }

    public void give() {
        given = true;
    }

    public boolean isGiven() {
        return given;
    }

    @Override
    public void interact(Player player) {


        if (given) {

        }

    }

}
