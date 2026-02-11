package game;

public class Colors {

    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String RESET = "\u001B[0m";
    public static final String CYAN = "\033[36m";
    public static final String YELLOW = "\033[33m";

    public static String paint(String color, String string) {
        return color + string + RESET;
    }


}
