package app.urlto.controller.api;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import app.urlto.dto.request.LoginRequest;
import app.urlto.dto.response.BaseResponse;
import app.urlto.service.impl.AuthServiceImpl;
import app.urlto.webcontants.Webcontants;
import jakarta.validation.Valid;
import lombok.Data;

@Data
public class AuthController {
    private final AuthServiceImpl authServiceImpl;

    @PostMapping("/api/auth/login")
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
}
