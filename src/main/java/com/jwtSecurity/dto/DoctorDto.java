package com.jwtSecurity.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.Data;

import java.util.List;

@Data

public class DoctorDto {

    private  long id;
    private String code;
    private  String name;
    private String address;
    private String email;
    private String contactNo;
    @ManyToMany
    private List<HospitalDto> hospitalDtos;

}
