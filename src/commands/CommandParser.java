package commands;

import java.util.HashMap;

public class CommandParser {

    private HashMap<String, Command> commands;
    private HashMap<String, String> dictionary;

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
        dictionary = new HashMap<>();
        dictionary.put("sever", "north");
        dictionary.put("jih", "south");
        dictionary.put("zapad", "west");
        dictionary.put("vychod", "east");
        dictionary.put("vysilacka", "radio");
        dictionary.put("antena", "antenna");
        dictionary.put("baterie", "battery");
        dictionary.put("provazek", "tape");
        dictionary.put("kousek kuze", "leather");
        dictionary.put("klacek", "stick");
        dictionary.put("sul", "salt");
        dictionary.put("ovoce", "fruit");
        dictionary.put("stul", "table");
        dictionary.put("ohniste", "campfire");
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
                argumentCommand.setArgument(dictionary.get(parts[1]));
            } catch (ArrayIndexOutOfBoundsException e) {
                throw new ArrayIndexOutOfBoundsException("Příkaz potřebuje argument");
            }
            return argumentCommand;
        }

        return command;
    }

}
