package com.jwtSecurity.services;

import com.jwtSecurity.dto.PassportDto;
import com.jwtSecurity.model.Passport;

public interface Passportservice {
    public PassportDto createPassport(PassportDto dto);
}
