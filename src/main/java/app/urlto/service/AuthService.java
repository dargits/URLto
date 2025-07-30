package app.urlto.service;

import app.urlto.dto.request.LoginRequest;
import app.urlto.dto.request.RegisterRequest;

public interface AuthService {
    public String login(LoginRequest loginRequest);

    public String register(RegisterRequest registerRequest);
}
