package app.urlto.controller.api;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import app.urlto.dto.request.LoginRequest;
import app.urlto.dto.request.RegisterRequest;
import app.urlto.dto.response.BaseResponse;
import app.urlto.service.impl.AuthServiceImpl;
import app.urlto.webcontants.Webcontants;
import jakarta.validation.Valid;
import lombok.Data;

@Data
@RestController
@RequestMapping(Webcontants.AUTH_V1_PATH)
public class AuthController {
    private final AuthServiceImpl authServiceImpl;

    @PostMapping("/login")
    public ResponseEntity<BaseResponse<String>> login(
            @Valid @RequestBody LoginRequest loginRequest,
            BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            Map<String, String> errors = new HashMap<>();
            for (FieldError error : bindingResult.getFieldErrors()) {
                errors.put(error.getField(), error.getDefaultMessage());
            }
            return ResponseEntity.badRequest().body(new BaseResponse<String>(Webcontants.FAIL, errors.toString()));
        }

        String token = authServiceImpl.login(loginRequest);

        return new ResponseEntity<>(new BaseResponse<String>(Webcontants.SUCCESS, token), HttpStatus.OK);
    }

    @PostMapping("/register")
    public ResponseEntity<BaseResponse<String>> register(
            @Valid @RequestBody RegisterRequest registerRequest,
            BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            Map<String, String> errors = new HashMap<>();
            for (FieldError error : bindingResult.getFieldErrors()) {
                errors.put(error.getField(), error.getDefaultMessage());
            }
            return ResponseEntity.badRequest().body(new BaseResponse<String>(Webcontants.FAIL, errors.toString()));
        }

        String message = authServiceImpl.register(registerRequest);

        return new ResponseEntity<>(new BaseResponse<String>(message, null), HttpStatus.OK);
    }
}
