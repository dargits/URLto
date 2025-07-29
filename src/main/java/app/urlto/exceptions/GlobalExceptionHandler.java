package app.urlto.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import app.urlto.dto.response.BaseResponse;
import app.urlto.exceptions.userexceptions.InvalidPasswordException;
import app.urlto.exceptions.userexceptions.UserNotFoundException;
import app.urlto.webcontants.Webcontants;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<BaseResponse<String>> handleUserNotFoundException(UserNotFoundException ex,
            WebRequest request) {
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(new BaseResponse<String>(Webcontants.ERROR, ex.getMessage()));
    }

    @ExceptionHandler(InvalidPasswordException.class)
    public ResponseEntity<BaseResponse<String>> handleInvalidPasswordException(InvalidPasswordException ex) {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(new BaseResponse<String>(Webcontants.ERROR, ex.getMessage()));
    }
}