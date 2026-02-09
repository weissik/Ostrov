package items;

import game.Player;

public class Antenna extends Item{

    public Antenna(String id, String name, String description, boolean portable) {
        super(id, name, description, portable);
    }

    @Override
    public void use(Player player) {

        if (player.getRadio() == null) throw new WrongUseException("Bez vysílačky je ti anténa na nic");

        player.getRadio().repairStep();

        System.out.println("Uspěšně jsi instaloval anténu pro vysílačku");

    }

}
