package app.urlto.service.impl;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import app.urlto.dto.request.LoginRequest;

import app.urlto.entity.User;
import app.urlto.exceptions.userexceptions.InvalidPasswordException;
import app.urlto.exceptions.userexceptions.UserNotFoundException;
import app.urlto.repository.UserRepository;
import app.urlto.sercurity.JwtTokenProvider;
import app.urlto.service.AuthService;
import app.urlto.webcontants.Webcontants;

import lombok.Data;

@Data
@Service
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;

    private final JwtTokenProvider jwtTokenProvider;

    private final BCryptPasswordEncoder passwordEncoder;

    @Override
    public String login(LoginRequest loginRequest) {

        String account = loginRequest.getAcoount();
        String password = loginRequest.getPassword();

        User user = userRepository.findByAccount(account)
                .orElseThrow(() -> new UserNotFoundException(Webcontants.USER_NOT_FOUND + account));
        if (!passwordEncoder.matches(password, user.getPassword())) {
            throw new InvalidPasswordException(Webcontants.INVALID_PASSWORD);
        }
        String roleName = (user.getRole() != null) ? user.getRole().getRoleName() : Webcontants.ROLE_USER;
        String token = jwtTokenProvider.generateToken(account, roleName);

        return token;
    }
}
