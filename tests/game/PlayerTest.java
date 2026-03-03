package game;

import items.Radio;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import world.Room;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    private Player player;
    private Room room1;
    private Radio radio;

    @BeforeEach
    void setUp(){
        Room room1 = new Room(null, null, null, true);
        this.room1 = new Room(null, null, null, true);
        player = new Player(room1, new Inventory(1));
        radio = new Radio("radio", null, null, true);
    }

    @Test
    void moveTo() {
        player.moveTo(room1);
        assertEquals(room1, player.getCurrentRoom());
    }

    @Test
    void playerHasRadio() {
        player.getInventory().addItem(radio);
        assertEquals(radio, player.getRadio());
    }

    @Test
    void playerDoesNotHaveRadio(){
        assertNull(player.getRadio());
    }

}