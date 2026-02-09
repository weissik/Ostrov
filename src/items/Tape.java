package items;

import game.Player;

public class Tape extends Item{

    public Tape(String id, String name, String description, boolean portable) {
        super(id, name, description, portable);
    }

    @Override
    public void use(Player player) {

        if (player.getRadio() == null) throw new WrongUseException("Bez vysílačky je ti provazek na nic");

        player.getRadio().repairStep();
        System.out.println("Uspěšně jsi upevnil vysílačku");

    }

}
