package game;

import items.Battery;
import items.Item;
import items.Tape;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InventoryTest {

    private final Inventory inventory = new Inventory(2);
    private Item item1;
    private Item item2;

    @BeforeEach
    void setUp(){
        item1 = new Tape("tape", null, null, true);
        item2 = new Battery("battry", null, null, true);
        inventory.addItem(item1);
    }

    @Test
    void getItem() {
        assertEquals(item1, inventory.getItem("tape"));
    }

    @Test
    void isFull() {
        inventory.addItem(item2);
        assertTrue(inventory.isFull());
    }

    @Test
    void removeItemById(){
        inventory.removeItemById("tape");
        assertNull(inventory.getItem("tape"));
    }

}