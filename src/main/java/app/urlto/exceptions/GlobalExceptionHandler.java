package app.urlto.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import app.urlto.dto.response.ErrorResponse;
import app.urlto.exceptions.linkexceptions.CustomShortCodeException;
import app.urlto.exceptions.linkexceptions.OriginalLinkException;
import app.urlto.exceptions.linkexceptions.ShortCodeExistsException;
import app.urlto.exceptions.linkexceptions.ShortCodeLengthException;
import app.urlto.exceptions.userexceptions.AccountExistsException;
import app.urlto.exceptions.userexceptions.InvalidPasswordException;
import app.urlto.exceptions.userexceptions.PasswordNotMatchException;
import app.urlto.exceptions.userexceptions.UserNotFoundException;
import app.urlto.webcontants.Webcontants;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleUserNotFoundException(UserNotFoundException ex,
            WebRequest request) {
        String error = ex.getMessage();

        return new ResponseEntity<>(
                new ErrorResponse(Webcontants.ERROR_CODE_USER_NOT_FOUND, error),
                HttpStatus.NOT_FOUND);
    }

    // Xử lý khi mật khẩu không hợp lệ
    @ExceptionHandler(InvalidPasswordException.class)
    public ResponseEntity<ErrorResponse> handleInvalidPasswordException(InvalidPasswordException ex) {
        String error = ex.getMessage();
        // Trả về ErrorResponse với mã lỗi int và thông báo
        return new ResponseEntity<>(
                new ErrorResponse(Webcontants.ERROR_CODE_INVALID_PASSWORD, error),
                HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(PasswordNotMatchException.class)
    public ResponseEntity<ErrorResponse> handlePasswordNotMatchException(PasswordNotMatchException ex) {
        String error = ex.getMessage();

        return new ResponseEntity<>(
                new ErrorResponse(Webcontants.ERROR_CODE_CONFIRM_PASSWORD_NOT_MATCH, error),
                HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ShortCodeExistsException.class)
    public ResponseEntity<ErrorResponse> handleShortCodeExistsException(ShortCodeExistsException ex) {
        String error = ex.getMessage();
        return new ResponseEntity<>(
                new ErrorResponse(Webcontants.ERROR_CODE_SHORTCODE_EXISTS, error),
                HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(AccountExistsException.class)
    public ResponseEntity<ErrorResponse> handleAccountExistsException(AccountExistsException ex) {
        String error = ex.getMessage();
        return new ResponseEntity<>(
                new ErrorResponse(Webcontants.ERROR_CODE_ACCOUNT_EXISTS, error),
                HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(CustomShortCodeException.class)
    public ResponseEntity<ErrorResponse> handleCustomShortCodeException(CustomShortCodeException ex) {
        String error = ex.getMessage();
        return new ResponseEntity<>(
                new ErrorResponse(Webcontants.ERROR_CODE_SHORTCODE_NOT_VALID, error),
                HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ShortCodeLengthException.class)
    public ResponseEntity<ErrorResponse> handleShortCodeLengthException(ShortCodeLengthException ex) {
        String error = ex.getMessage();
        return new ResponseEntity<>(
                new ErrorResponse(Webcontants.ERROR_CODE_ACCOUNT_EXISTS, error),
                HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(OriginalLinkException.class)
    public ResponseEntity<ErrorResponse> handleOriginalLinkException(OriginalLinkException ex) {
        String error = ex.getMessage();
        return new ResponseEntity<>(
                new ErrorResponse(Webcontants.ERROR_CODE_ORIGINALLINK_START_WITH_BACKEND_URL, error),
                HttpStatus.BAD_REQUEST);
    }

}
