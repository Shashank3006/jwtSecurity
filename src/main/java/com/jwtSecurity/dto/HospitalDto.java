package com.jwtSecurity.dto;


import jakarta.persistence.ManyToMany;
import lombok.Data;

import java.util.List;

@Data
public class HospitalDto {

    private  long id;
    private String code;
    private  String name;
    private String location;
    @ManyToMany
    private List<DoctorDto> doctorDtos;
}
