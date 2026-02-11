package game;

import commands.CommandParser;
import commands.WrongCommandException;
import items.WrongUseException;
import world.GameData;
import world.Room;
import world.World;
import world.WorldBuilder;

import java.util.ArrayList;
import java.util.Scanner;

public class Game {

    private final World world;
    private final Player player;
    private final CommandParser parser;
    private boolean running;
    private boolean won;
    private final ArrayList<String> commands;

    public Game(World world, Player player, CommandParser parser) {
        this.world = world;
        this.player = player;
        this.parser = parser;
        this.running = false;
        this.won = false;
        commands = new ArrayList<>();
        commands.add("jdi <směr>");
        commands.add("vezmi <předmět>");
        commands.add("poloz <předmět>");
        commands.add("pouzij <předmět>");
        commands.add("mluv");
        commands.add("prozkoumej");
        commands.add("pomoc");
        commands.add("napoveda");
        commands.add("konec");
    }

    public World getWorld() {
        return world;
    }

    public void win() {
        this.won = true;
    }

    public static Game LOAD_GAME(){

        GameData data = GameData.loadGameData("/gameData.json");
        World world = WorldBuilder.buildWorld(data);
        Player player = new Player(world.getStartingRoom(), new Inventory(3));
        CommandParser commandParser = new CommandParser();

        return new Game(world, player, commandParser);

    }

    public void runGame() {
        introductoryText();
        running = true;
        Scanner sc = new Scanner(System.in);
        System.out.println(Colors.paint(Colors.GREEN, "\nPokračovat >>"));
        sc.nextLine();
        printCommands();
        System.out.println("\nSeznam lze kdykoli zobrazit prikazem 'pomoc'");
        System.out.println(Colors.paint(Colors.GREEN, "\nZačít hru >>"));
        sc.nextLine();
        info();
        do {
            Room room = player.getCurrentRoom();
            System.out.println("\n" + Colors.paint(Colors.GREEN, "Zadej příkaz >>"));
            String input = sc.nextLine();
            processCommand(input);
            if (player.getCurrentRoom() != room) {
                System.out.println("\n\n");
                info();
            }
        } while (running);

    }

    public void processCommand(String input){
        try {
            parser.parse(input).execute(this, player, world);
        } catch (WrongCommandException | WrongUseException | ArrayIndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }
    }

    public void endGame(){
        running = false;
        if (won) {
            System.out.println("\n\nVítr na vrcholu ostrova je silný, ale tentokrát už tě nezastaví. S opravenou vysílačkou pevně sevřenou v rukou" +
                    "\nnaposledy zkontroluješ spojení. Anténa drží. Baterie je zapojená. Všechno, co jsi našel, všechno, co jsi dokázal" +
                    "\nvedlo k tomuto okamžiku.\n\n" +
                    "Zhluboka se nadechneš a stiskneš tlačítko vysílání.\n\n" +
                    "Z reproduktoru se ozve šum. Nekonečné vteřiny ticha.\n" +
                    "A pak — „…Signál přijat. Opakujte svou polohu.“\n" +
                    "Srdce se ti rozbuší. Funguje to. Opravdu to funguje.\n\n" +
                    "Když se nad obzorem objeví silueta záchranného vrtulníku, konečně si dovolíš uvěřit, že je konec. Přežil jsi." +
                    "Ne díky štěstí, ale díky odhodlání, rozumu a vytrvalosti.\n" +
                    "Ostrov, který se měl stát tvým koncem, se stal důkazem, že se nevzdáváš.\n\n" +
                    "Záchrana je tady.\n\n" + Colors.paint(Colors.GREEN, "Gratuluji, vyhrál jsi!"));
        } else {
            System.out.println("\n\nKONEC HRY\n\n" + Colors.paint(Colors.RED, "Hra byla ukončena bez vítezství"));
        }
    }

    public void introductoryText() {
        System.out.println("\n === OSTROV ===\n\n" +
                "Temné mraky se rychle stahují a mořská hladina se začíná bouřit. Co mělo být obyčejným školním výletem se během" +
                "\nněkolika minut proměnilo v noční můru. Loď, na které jsi s třídou plul, byla stržena prudkou bouří z kurzu a nakonec " +
                "\nztroskotala o ostré útesy neznámého ostrova.\n\n" +
                "Probouzíš se sám na písečné pláži, obklopený neznámou divočinou. Nevíš, kde jsou ostatní, nevíš, co se stalo.\n" +
                "Dezorientace a šok tě svírají, ale brzy si uvědomíš jednu věc – panika tě nezachrání. Musíš jednat.\n\n" +
                "Na pláži leží rozbitá vysílačka – jediná šance na spojení se světem, která však potřebuje opravit. Chybí jí anténa,\n" +
                "baterie a je zanesená pískem. Tvůj cíl je jasný: opravit vysílačku a vyslat signál z nejvyššího bodu ostrova.\n\n" +
                "Ostrov je tajemný a nebezpečný, ale každý krok tě přibližuje k přežití a naději na záchranu. Vydej se na průzkum, " +
                "hledej potřebné zásoby\na buď připraven čelit tomu, co ti neznámý ostrov připravil.\n\n" +
                "Tvá cesta začíná… teď.");
    }

    public void info() {
        System.out.println("=== " + Colors.paint(Colors.RED, player.getCurrentRoom().getName()) + " ===" );
        System.out.println(Colors.paint(Colors.YELLOW, player.getCurrentRoom().getDescription()));
        System.out.println(Colors.paint(Colors.CYAN, "Cesty: ") + player.getCurrentRoom().printExits());
        if (player.getCurrentRoom().getCharacter() != null) System.out.println(Colors.paint(Colors.CYAN, "Postava: ") + player.getCurrentRoom().getCharacter().getName());
        player.getInventory().getInfo();
    }

    public void printCommands(){
        System.out.println(Colors.paint(Colors.CYAN, "\nDostupné příkazy:"));
        for (String command : commands) System.out.println(command);
    }







}
