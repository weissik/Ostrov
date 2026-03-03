package items;

import game.Player;

/**
 * Class represents a stick used to make a torch
 */
public class Stick extends Item{

    private boolean isOnFire;

    public Stick(String id, String name, String description, boolean portable) {
        super(id, name, description, portable);
        this.isOnFire = false;

    }

    /**
     * Lights the stick and makes it a torch
     */
    public void setOnFire() {
        isOnFire = true;
    }

    /**
     * Checks if the sick is on fire and if the player is in correct location then unlocks a new direction
     * @param player
     */
    @Override
    public void use(Player player) {

        if (!isOnFire) throw new WrongUseException("Samotný klacek k ničemu není, ale mohl mohl by se hodit pro pochodeň");

        if (player.getCurrentRoom().getId().equals("jungle")) {
            player.getCurrentRoom().getExit("north").setBlocked(false);
            System.out.println("Pochodní jsi rozsvítil v jeskyni, nyní můžeš dál");
        } else if (player.getCurrentRoom().getId().equals("swamp")){
            player.getCurrentRoom().getExit("west").setBlocked(false);
            System.out.println("Pochodní jsi rozsvítil v jeskyni, nyní můžeš dál");
        } else {
            throw new WrongUseException("Pochodeň lze použít pouze před vstupem do jeskyně");
        }


    }

}

