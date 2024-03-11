package com.jwtSecurity.mapper;

import com.jwtSecurity.dto.PassportDto;
import com.jwtSecurity.model.Passport;

public class PassportMapper {
    public static Passport toEntity(PassportDto dto){
        Passport entity  = new Passport();
        entity.setPassportNo(dto.getPassportNo());
        return entity;
    }
    public static PassportDto toDto(Passport entity){
        PassportDto dto=new PassportDto();
        dto.setId(entity.getId());
        dto.setPassportNo(entity.getPassportNo());

        return dto;
    }
}
