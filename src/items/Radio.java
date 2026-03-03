package items;

import game.Player;

/**
 * Class represents a radio which has to be repaired to win the game
 */
public class Radio extends Item{

    private int repairProgress;

    public Radio(String id, String name, String description, boolean portable) {
        super(id, name, description, portable);
        this.repairProgress = 0;
    }

    /**
     * Checks whether the radio is repaired
     * @return boolean whether the radio is repaired
     */
    public boolean isRepaired() {
        return repairProgress >= 3;
    }

    /**
     * Increases repairProgress by one
     */
    public void repairStep() {
        repairProgress++;
    }

    /**
     * Checks if the radio is repaired and if the player is in correct location
     * @param player player using this item
     */
    @Override
    public void use(Player player) {

        if (!isRepaired()) throw new WrongUseException("Vysílačka ještě není funkční");

        if (!player.getCurrentRoom().getId().equals("mountain_peak")) throw new WrongUseException("Signál lze navázat jen z nejvyššího bodu ostrova");

    }

}
