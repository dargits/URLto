package app.urlto.exceptions.linkexceptions;

public class CustomShortCodeException extends RuntimeException {
    public CustomShortCodeException(String message) {
        super(message);
    }

    public CustomShortCodeException(String message, Throwable cause) {
        super(message, cause);
    }
}
