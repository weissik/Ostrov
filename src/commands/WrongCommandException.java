package commands;

/**
 * Exception for command that does not exist
 */
public class WrongCommandException extends RuntimeException {
    public WrongCommandException(String message) {
        super(message);
    }
}
