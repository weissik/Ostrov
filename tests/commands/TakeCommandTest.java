package commands;

import characters.Native;
import game.Inventory;
import game.Player;
import items.CampFire;
import items.Fruit;
import items.Item;
import items.Tape;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import world.Room;

import static org.junit.jupiter.api.Assertions.*;

class TakeCommandTest {

    private TakeCommand command;
    private Player player;
    private Item item1;
    private Native character;

    @BeforeEach
    void setUp(){
        command = new TakeCommand();
        Room room = new Room(null, null, null, false);
        player = new Player(room, new Inventory(1));
        item1 = new Fruit("fruit", null, null, true);
        Item item2 = new CampFire("campfire", null, null, false);
        Item item3 = new Tape("tape", null, null, true);
        character = new Native(null, null);
        room.setCharacter(character);
        room.addItem(item1);
        room.addItem(item2);
        room.addItem(item3);
    }

    @Test
    void takeItem() {
        command.setArgument("fruit");
        command.execute(null, player, null);
        assertEquals(item1, player.getInventory().getItem("fruit"));
        assertNull(player.getCurrentRoom().getItem("fruit"));
    }

    @Test
    void takeUnportableItem(){
        command.setArgument("campfire");
        assertThrows(WrongCommandException.class, () -> command.execute(null, player, null));
    }

    @Test
    void takeBlockedItem(){
        command.setArgument("tape");
        assertThrows(WrongCommandException.class, () -> command.execute(null, player, null));
    }

    @Test
    void inventoryIsFull(){
        character.give();
        command.setArgument("fruit");
        command.execute(null, player, null);
        command.setArgument("tape");
        assertThrows(WrongCommandException.class, () -> command.execute(null, player, null));
    }


}