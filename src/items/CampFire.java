package items;

import game.Player;

public class CampFire extends Item{
    public CampFire(String id, String name, String description, boolean portable) {
        super(id, name, description, portable);
    }

    @Override
    public void use(Player player) {

        if (player.getInventory().getItem("stick") == null) throw new WrongUseException("Nemáš co bys zapálil");

        Stick item = (Stick) player.getInventory().getItem("stick");
        item.setOnFire();
        System.out.println("Zapálil jsi pochodeň");

    }
}
