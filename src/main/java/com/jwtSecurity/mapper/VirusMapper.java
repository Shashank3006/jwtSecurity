package com.jwtSecurity.mapper;

import com.jwtSecurity.dto.VirusDto;
import com.jwtSecurity.model.Virus;

public class VirusMapper {
    public static VirusDto toDto(Virus virus){
        VirusDto dto=new VirusDto();
        dto.setId(virus.getId());
        dto.setName(virus.getName());
        dto.setVariant(virus.getVariant());
        return dto;
    }
    public static Virus toEntity(VirusDto dto){
        Virus virus= new Virus();
        virus.setName(dto.getName());
        virus.setVariant(dto.getVariant());
        return virus;
    }
}
