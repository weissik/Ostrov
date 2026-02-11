package items;

import game.Player;

public class Stick extends Item{

    private boolean isOnFire;

    public Stick(String id, String name, String description, boolean portable) {
        super(id, name, description, portable);
        this.isOnFire = false;

    }

    public void setOnFire() {
        isOnFire = true;
    }

    @Override
    public void use(Player player) {

        if (!isOnFire) throw new WrongUseException("Samotný klacek k ničemu není, ale mohl mohl by se hodit pro pochodeň");

        if (!player.getCurrentRoom().getId().equals("jungle") || !player.getCurrentRoom().getId().equals("swamp")) throw new WrongUseException("Pochodeň lze použít pouze před vstupem do jeskyně");

        player.getCurrentRoom().getExit("north").setBlocked(false);
        System.out.println("Pochodní jsi rozsvítil v jeskyni, nyní můžeš dál");

    }

}

