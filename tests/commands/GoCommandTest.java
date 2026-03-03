package commands;

import game.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import world.Room;

import static org.junit.jupiter.api.Assertions.*;


class GoCommandTest {

    private GoCommand command;
    private Player player;
    private Room room1;
    private Room room2;

    @BeforeEach
    void setUp(){
        command = new GoCommand();

        room1 = new Room(null, "Start", null, false);
        room2 = new Room(null, "North", null,false);
        room1.addExit("north", room2);

        player = new Player(room1, null);
    }


    @Test
    void moveInDirections() {
        command.setArgument("north");
        command.execute(null, player,null);
        assertEquals(room2, player.getCurrentRoom());
    }

    @Test
    void nullArgument(){
        assertThrows(WrongCommandException.class, () -> command.execute(null, player, null));
    }

    @Test
    void invalidDirection(){
        command.setArgument("south");
        assertThrows(WrongCommandException.class, () -> command.execute(null, player, null));
    }

    @Test
    void blockedRoom(){
        Room blockedRoom = new Room(null, "Blocked", null, true);
        room1.addExit("east", blockedRoom);
        command.setArgument("east");
        assertThrows(WrongCommandException.class, () -> command.execute(null, player, null));
    }

}