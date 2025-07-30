package app.urlto.dto.request;

import org.hibernate.validator.constraints.URL;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class LinkRequest {
    @NotBlank(message = "Link gốc không được để trống.")
    @URL(message = "Link gốc phải là một URL hợp lệ.")
    private String originalLink;
    private String customShortCode;
}
