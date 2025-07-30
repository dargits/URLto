package app.urlto.exceptions.linkexceptions;

public class ShortCodeLengthException extends RuntimeException {
    public ShortCodeLengthException(String message) {
        super(message);
    }

    public ShortCodeLengthException(String message, Throwable cause) {
        super(message, cause);
    }
}
