package com.jwtSecurity.controller;

import com.jwtSecurity.dto.PassportDto;
import com.jwtSecurity.services.Passportservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PassportController {
    @Autowired
    private Passportservice passportservice;
    @PostMapping("/passportCre")
    public PassportDto savePassport(@RequestBody PassportDto dto){
        return passportservice.createPassport(dto);
    }
}
