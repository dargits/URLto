package app.urlto.exceptions.linkexceptions;

public class OriginalLinkException extends RuntimeException {
    public OriginalLinkException(String message) {
        super(message);
    }

    public OriginalLinkException(String message, Throwable cause) {
        super(message, cause);
    }
}
