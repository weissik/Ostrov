package commands;

/**
 * Iterface for command witch needs argument
 */
public interface ArgumentCommand extends Command{

    void setArgument(String argument);

}
