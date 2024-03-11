package com.jwtSecurity.services.impl;

import com.jwtSecurity.dao.PassportDao;
import com.jwtSecurity.dto.PassportDto;
import com.jwtSecurity.mapper.PassportMapper;
import com.jwtSecurity.model.Passport;
import com.jwtSecurity.services.Passportservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PassportServiceImpl implements Passportservice {
    @Autowired
   private PassportDao dao;
    @Override
    public PassportDto createPassport(PassportDto dto) {
        Passport passport=PassportMapper.toEntity(dto);
        Passport passport1=dao.save(passport);
        PassportDto pass=PassportMapper.toDto(passport1);

        return pass;
    }
}
