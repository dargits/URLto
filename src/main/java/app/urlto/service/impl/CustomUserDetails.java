package app.urlto.service.impl;

import java.util.Collections;
import java.util.Optional;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import app.urlto.entity.User;
import app.urlto.repository.UserRepository;
import lombok.Data;

@Service
@Data
public class CustomUserDetails implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String account) throws UsernameNotFoundException {
        Optional<User> userOptional = userRepository.findByAccount(account);
        if (!userOptional.isPresent()) {
            throw new UsernameNotFoundException("User not found with account: " + account);
        }
        User user = userOptional.get();

        String roleWithPrefix = "ROLE_" + user.getRole().getRoleName();
        return new org.springframework.security.core.userdetails.User(
                user.getAccount(),
                user.getPassword(),
                Collections.singletonList(new SimpleGrantedAuthority(roleWithPrefix)));
    }
}