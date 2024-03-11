package com.jwtSecurity.services;

import com.jwtSecurity.dto.VirusDto;
import org.springframework.http.ResponseEntity;

public interface VirusService {
    VirusDto saveVirus(VirusDto dto);
    public VirusDto findByName(String name);
}
