package com.jwtSecurity.mapper;

import com.jwtSecurity.dto.DoctorDto;
import com.jwtSecurity.model.Doctor;

public class DoctorMapper {
    public static DoctorDto toDto(Doctor doctor){
        DoctorDto dto=new DoctorDto();
        dto.setId(doctor.getId());
        dto.setCode(doctor.getCode());
        dto.setName(doctor.getName());
        dto.setAddress(doctor.getAddress());
        dto.setEmail(doctor.getEmail());
        dto.setContactNo(doctor.getContactNo());
        return dto;
    }
    public static Doctor toEntity(DoctorDto dto){
        Doctor doctor=new Doctor();
        doctor.setCode(dto.getCode());
        doctor.setName(dto.getName());
        doctor.setAddress(dto.getAddress());
        doctor.setEmail(dto.getEmail());
        doctor.setContactNo(dto.getContactNo());
        return doctor;
    }

}
