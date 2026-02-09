package items;

import game.Player;

public class Radio extends Item{

    private int repairProgress;

    public Radio(String id, String name, String description, boolean portable) {
        super(id, name, description, portable);
        this.repairProgress = 0;
    }

    public boolean isRepaired() {
        return repairProgress >= 3;
    }

    public void repairStep() {
        repairProgress++;
    }

    @Override
    public void use(Player player) {

        if (!isRepaired()) throw new WrongUseException("Vysílačka ještě není funkční");

        if (!player.getCurrentRoom().getId().equals("mountain_peak")) throw new WrongUseException("Signál lze navázat jen z nejvyššího bodu ostrova");

    }

}
