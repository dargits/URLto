package app.urlto.dto.response;

import lombok.Data;

@Data
public class WebInforResponse {
    private String webName;
    private String gitHub;
    private String author;

    public WebInforResponse(String webName, String gitHub, String author) {
        this.webName = webName;
        this.gitHub = gitHub;
        this.author = author;
    }

}
