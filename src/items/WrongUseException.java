package items;

/**
 * Exception for using an item when it is not possible
 */
public class WrongUseException extends RuntimeException {
    public WrongUseException(String message) {
        super(message);
    }
}
