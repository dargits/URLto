package app.urlto.service.impl;

import org.springframework.stereotype.Service;

import app.urlto.dto.response.BaseResponse;
import app.urlto.dto.response.WebInforResponse;
import app.urlto.webcontants.Webcontants;

@Service
public class WebInforService {
    @SuppressWarnings({ "unchecked", "rawtypes" })
    public BaseResponse<WebInforResponse> getWebInfor() {
        String WEB_NAME = Webcontants.WEB_NAME;
        String AUTHOR_NAME = Webcontants.AUTHOR;
        String GIT_HUB = Webcontants.GIT_HUB;
        WebInforResponse webInforResponse = new WebInforResponse(WEB_NAME, AUTHOR_NAME, GIT_HUB);

        return new BaseResponse(Webcontants.SUCCESS, webInforResponse);
    }

    public BaseResponse<String> getBackEndDomain() {
        return new BaseResponse<String>(Webcontants.SUCCESS, Webcontants.BACK_END_DOMAIN);
    }
}
