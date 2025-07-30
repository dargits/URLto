package app.urlto.service;

import app.urlto.dto.request.LinkRequest;

public interface LinkService {
    public String createShortLink(LinkRequest linkRequest);

    public String randomShortCode();

    public boolean isValidShortCode(String shortCode);

    public String createShortCode();
}
