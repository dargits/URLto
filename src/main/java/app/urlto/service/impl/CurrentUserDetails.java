package app.urlto.service.impl;

import java.util.Optional;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import app.urlto.entity.User;
import app.urlto.repository.UserRepository;
import lombok.Data;

@Service
@Data
public class CurrentUserDetails {

    private final UserRepository userRepository;

    // lay user trong request
    public User getUserDetails() {
        Authentication authentication = SecurityContextHolder.getContext()
                .getAuthentication();
        // Lấy UserDetails từ Authentication
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        Optional<User> userOptional = userRepository.findByAccount(userDetails.getUsername());
        return userOptional.get();
    }
}
