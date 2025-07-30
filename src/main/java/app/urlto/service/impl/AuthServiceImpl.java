package app.urlto.service.impl;

import java.time.LocalDateTime;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import app.urlto.dto.request.LoginRequest;
import app.urlto.dto.request.RegisterRequest;
import app.urlto.entity.Role;
import app.urlto.entity.User;
import app.urlto.exceptions.userexceptions.AccountExistsException;
import app.urlto.exceptions.userexceptions.InvalidPasswordException;
import app.urlto.exceptions.userexceptions.PasswordNotMatchException;
import app.urlto.exceptions.userexceptions.UserNotFoundException;
import app.urlto.repository.RoleRepository;
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

    private final RoleRepository roleRepository;

    @Override
    public String login(LoginRequest loginRequest) {

        String account = loginRequest.getAccount();
        String password = loginRequest.getPassword();

        User user = userRepository.findByAccount(account)
                .orElseThrow(() -> new UserNotFoundException(Webcontants.ACCOUNT_NOT_FOUND + account));
        if (!passwordEncoder.matches(password, user.getPassword())) {
            throw new InvalidPasswordException(Webcontants.INVALID_PASSWORD);
        }
        String roleName = (user.getRole() != null) ? user.getRole().getRoleName() : Webcontants.ROLE_USER;
        String token = jwtTokenProvider.generateToken(account, roleName);

        return token;
    }

    @Override
    public String register(RegisterRequest registerRequest) {
        String account = registerRequest.getAccount();
        String password = registerRequest.getPassword();
        String confirmPassword = registerRequest.getConfirmPassword();

        if (userRepository.existsByAccount(account))
            throw new AccountExistsException(Webcontants.ACCOUNT_ALREADY_EXISTS);
        if (!password.equals(confirmPassword))
            throw new PasswordNotMatchException(Webcontants.CONFIRM_PASSWORD_NOT_MATCH);

        password = passwordEncoder.encode(password);

        User user = new User();
        Role role = roleRepository.findByRoleName(Webcontants.ROLE_USER);
        user.setAccount(account);
        user.setPassword(password);
        user.setRole(role);
        user.setCreateAt(LocalDateTime.now());

        userRepository.save(user);

        return Webcontants.SUCCESS;
    }
}
