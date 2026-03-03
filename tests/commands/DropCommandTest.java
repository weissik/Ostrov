package commands;

import game.Inventory;
import game.Player;
import items.Battery;
import items.Item;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import world.Room;

import static org.junit.jupiter.api.Assertions.*;

class DropCommandTest {

    private DropCommand command;
    private Player player;
    private Item item;

    @BeforeEach
    void setUp(){
        command = new DropCommand();
        player = new Player(new Room(null, null, null,false), new Inventory(1));
        item = new Battery("battery",null,null,true);
        player.getInventory().addItem(item);
    }


    @Test
    void dropItem(){
        command.setArgument("battery");
        command.execute(null, player, null);
        assertNull(player.getInventory().getItem("battery"));
        assertEquals(item, player.getCurrentRoom().getItem("battery"));
    }

    @Test
    void nullArgument(){
        assertThrows(WrongCommandException.class, () -> command.execute(null, player, null));
    }

    @Test
    void itemNotInInventory(){
        command.setArgument("tape");
        assertThrows(WrongCommandException.class, () -> command.execute(null, player, null));
    }

}