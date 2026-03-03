package commands;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CommandParserTest {

    private final CommandParser parser = new CommandParser();

    @Test
    void goCommand() {
        Command command = parser.parse("jdi sever");
        assertEquals(GoCommand.class, command.getClass());
    }

    @Test
    void invalidCommand(){
        assertThrows(WrongCommandException.class, () -> parser.parse("neznamy prikaz"));
    }

    @Test
    void argumentCommand(){
        Command command = parser.parse("jdi sever");
        assertInstanceOf(ArgumentCommand.class, command);
    }

    @Test
    void argumentCommandWithoutArgument(){
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> parser.parse("jdi"));
    }


}