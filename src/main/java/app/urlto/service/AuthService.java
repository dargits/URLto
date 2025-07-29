package app.urlto.service;

import app.urlto.dto.request.LoginRequest;

public interface AuthService {
    public String login(LoginRequest loginRequest);
}
