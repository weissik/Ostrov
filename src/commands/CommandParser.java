package commands;

import game.Dictionary;

import java.util.HashMap;

public class CommandParser {

    private HashMap<String, Command> commands;

    public CommandParser() {
        commands = new HashMap<>();
        commands.put("jdi", new GoCommand());
        commands.put("vezmi", new TakeCommand());
        commands.put("poloz", new DropCommand());
        commands.put("pouzij", new UseCommand());
        commands.put("mluv", new TalkCommand());
        commands.put("prozkoumej", new ExploreCommand());
        commands.put("napoveda", new HintCommand());
        commands.put("pomoc", new HelpCommand());
        commands.put("konec", new EndCommand());
    }

    public Command parse(String input) throws ArrayIndexOutOfBoundsException {

        String[] parts = input.trim().split(" ", 2);

        Command command = commands.get(parts[0]);

        if (command == null){
            throw new WrongCommandException("Neznámý příkaz");
        }

        if (command instanceof ArgumentCommand){
            ArgumentCommand argumentCommand = (ArgumentCommand) command;
            try {
                argumentCommand.setArgument(Dictionary.translate(parts[1]));
            } catch (ArrayIndexOutOfBoundsException e) {
                throw new ArrayIndexOutOfBoundsException("Příkaz potřebuje argument");
            }
            return argumentCommand;
        }

        return command;
    }

}
