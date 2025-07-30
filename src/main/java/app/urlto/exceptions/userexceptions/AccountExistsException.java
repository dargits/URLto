package app.urlto.exceptions.userexceptions;

public class AccountExistsException extends RuntimeException {
    public AccountExistsException(String message) {
        super(message);
    }

    public AccountExistsException(String message, Throwable cause) {
        super(message, cause);
    }

}
