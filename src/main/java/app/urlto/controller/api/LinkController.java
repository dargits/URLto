package app.urlto.controller.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import app.urlto.dto.request.LinkRequest;
import app.urlto.dto.response.BaseResponse;
import app.urlto.service.impl.LinkServiceImpl;
import app.urlto.webcontants.Webcontants;
import jakarta.validation.Valid;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping(Webcontants.LINK_API_V1_PATH)
@Data
public class LinkController {
    private final LinkServiceImpl linkServiceImpl;

    @PostMapping("/create")
    public ResponseEntity<BaseResponse<String>> shortLink(
            @Valid @RequestBody LinkRequest linkRequest,
            BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            Map<String, String> errors = new HashMap<>();
            for (FieldError error : bindingResult.getFieldErrors()) {
                errors.put(error.getField(), error.getDefaultMessage());
            }
            return ResponseEntity.badRequest().body(new BaseResponse<String>(Webcontants.FAIL, errors.toString()));
        }
        String shortLink = linkServiceImpl.createShortLink(linkRequest);
        return new ResponseEntity<BaseResponse<String>>(new BaseResponse<String>(Webcontants.SUCCESS, shortLink),
                HttpStatus.CREATED);
    }

}
