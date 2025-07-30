package app.urlto.service.impl;

import java.security.SecureRandom;
import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import app.urlto.dto.request.LinkRequest;
import app.urlto.entity.Link;
import app.urlto.entity.User;
import app.urlto.exceptions.linkexceptions.CustomShortCodeException;
import app.urlto.exceptions.linkexceptions.OriginalLinkException;
import app.urlto.exceptions.linkexceptions.ShortCodeExistsException;
import app.urlto.exceptions.linkexceptions.ShortCodeLengthException;
import app.urlto.repository.LinkRepository;
import app.urlto.service.LinkService;
import app.urlto.webcontants.Webcontants;
import lombok.Data;

@Service
@Data
public class LinkServiceImpl implements LinkService {

    private final LinkRepository linkRepository;

    private final CurrentUserDetails currentUserDetails;

    @Override
    public String createShortLink(LinkRequest linkRequest) {
        String shortCode = linkRequest.getCustomShortCode().trim().replaceAll("\\s", "");
        String originalLink = linkRequest.getOriginalLink();
        if (originalLink.startsWith(Webcontants.BACK_END_DOMAIN))
            throw new OriginalLinkException(Webcontants.ERROR_MESSAGE_ORIGINALLINK_START_WITH_BACKEND_URL);
        Link shortLink = new Link();
        User user = currentUserDetails.getUserDetails();
        if (shortCode != null && !shortCode.isEmpty()) {
            if (shortCode.length() < Webcontants.SHORTCODE_LENGTH)
                throw new ShortCodeLengthException(Webcontants.ERROR_MESSAGE_SHORTCODE_LENGTH);
            if (!shortCode.matches("^[a-zA-Z0-9]+$")) {
                throw new CustomShortCodeException(Webcontants.ERROR_MESSAGE_SHORTCODE_NOT_VALID);
            }
            if (!isValidShortCode(shortCode)) {
                shortLink.setActive(true);
                shortLink.setCreateAt(LocalDateTime.now());
                shortLink.setShortCode(shortCode);
                shortLink.setUser(user);
                shortLink.setOriginalLink(originalLink);
                shortLink.setShortLink(Webcontants.BACK_END_DOMAIN + "/" + shortCode);

                linkRepository.save(shortLink);
                return shortLink.getShortLink();
            }
            throw new ShortCodeExistsException(Webcontants.ERROR_MESSAGE_SHORTCODE_EXISTS + shortCode);
        }
        shortCode = createShortCode();
        shortLink.setActive(true);
        shortLink.setCreateAt(LocalDateTime.now());
        shortLink.setShortCode(shortCode);
        shortLink.setUser(user);
        shortLink.setOriginalLink(originalLink);
        shortLink.setShortLink(Webcontants.BACK_END_DOMAIN + "/" + shortCode);

        linkRepository.save(shortLink);

        return shortLink.getShortLink();
    }

    @Override
    public String randomShortCode() {
        SecureRandom random = new SecureRandom();
        StringBuffer shortCode = new StringBuffer();

        for (int i = 0; i < Webcontants.SHORTCODE_LENGTH; i++) {
            int randomIndex = random.nextInt(Webcontants.URL_ALPHABET.length());
            shortCode.append(Webcontants.URL_ALPHABET.charAt(randomIndex));
        }
        return shortCode.toString();
    }

    @Override
    public boolean isValidShortCode(String shortCode) {
        return linkRepository.existsByShortCode(shortCode);
    }

    @Override
    public String createShortCode() {
        String shortCode;
        do {
            shortCode = randomShortCode();
        } while (isValidShortCode(shortCode));
        return shortCode;
    }

}
