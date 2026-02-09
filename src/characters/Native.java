package characters;

import game.Player;

public class Native extends Character{

    private boolean given;

    public Native(String name, String id) {
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

        if (!given) {
            System.out.println("Měl bych pro tebe provazek, který by se ti mohl hodit, ale chci za neěj nějakou kůži");
        } else {
            System.out.println("Za jeskyní je vrchol hory odtamtud by šel dobře vyslat signál");
        }

    }

}
