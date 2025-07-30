package app.urlto.exceptions.linkexceptions;

public class ShortCodeExistsException extends RuntimeException {
    public ShortCodeExistsException(String message) {
        super(message);
    }

    public ShortCodeExistsException(String message, Throwable cause) {
        super(message, cause);
    }
}
