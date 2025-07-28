package app.urlto.controller.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import app.urlto.dto.response.BaseResponse;
import app.urlto.service.impl.WebInforService;
import app.urlto.webcontants.Webcontants;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping(Webcontants.WEB_PATH)
@Data
public class WebInforController {
    private final WebInforService webInforService;

    @SuppressWarnings("rawtypes")
    @GetMapping(Webcontants.GET_WEB_INFOR)
    public ResponseEntity<BaseResponse> getWebInfor() {
        BaseResponse webInfor = webInforService.getWebInfor();
        HttpStatus httpStatus = HttpStatus.OK;

        return new ResponseEntity<BaseResponse>(webInfor, httpStatus);
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @GetMapping(Webcontants.GET_BACKEND_DOMAIN)
    public ResponseEntity<BaseResponse<String>> getBackEndDomain() {
        BaseResponse backEndDomain = webInforService.getBackEndDomain();
        HttpStatus httpStatus = HttpStatus.OK;

        return new ResponseEntity<BaseResponse<String>>(backEndDomain, httpStatus);
    }

}
