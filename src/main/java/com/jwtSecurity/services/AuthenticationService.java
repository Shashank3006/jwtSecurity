package com.jwtSecurity.services;

import com.jwtSecurity.dto.AuthenticationResponse;
import com.jwtSecurity.model.User;

public interface AuthenticationService {
    public AuthenticationResponse regusterUserRequest(User request);
    public AuthenticationResponse authenticate(User request);
}
