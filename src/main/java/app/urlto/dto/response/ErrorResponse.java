package app.urlto.dto.response;

import lombok.Data;

@Data
public class ErrorResponse {
    private int code;
    private String message;

    public ErrorResponse(int code, String message) {
        this.code = code;
        this.message = message;
    }

}
