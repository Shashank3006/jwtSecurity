package com.jwtSecurity.mapper;

import com.jwtSecurity.dto.DoctorDto;
import com.jwtSecurity.dto.HospitalDto;
import com.jwtSecurity.model.Doctor;
import com.jwtSecurity.model.Hospital;

import java.util.ArrayList;
import java.util.List;

public class HospitalMapper {
    public static HospitalDto toDto(Hospital hospital){
        HospitalDto dto=new HospitalDto();
        dto.setId(hospital.getId());
        dto.setCode(hospital.getCode());
        dto.setName(hospital.getName());
        dto.setLocation(hospital.getLocation());
      List<HospitalDto> hospitals=new ArrayList<>();
        hospitals.add(dto);


        List<DoctorDto> doctorDos=new ArrayList<>();
        for (Doctor doctor:hospital.getDoctors()){
            DoctorDto dto1=new DoctorDto();
            dto1.setId(doctor.getId());
            dto1.setName(doctor.getName());
            dto1.setEmail(doctor.getEmail());
            dto1.setAddress(doctor.getAddress());
            dto1.setContactNo(doctor.getContactNo());
            dto1.setCode(doctor.getCode());
            dto1.setHospitalDtos(hospitals);
            doctorDos.add(dto1);

        }
        dto.setDoctorDtos(doctorDos);

        return dto;
    }
    public static Hospital toEntity(HospitalDto dto){
        Hospital hospital=new Hospital();
        hospital.setCode(dto.getCode());
        hospital.setName(dto.getName());
        hospital.setLocation(dto.getLocation());
       List<Hospital> hospitals=new ArrayList<>();
        hospitals.add(hospital);

        List<Doctor> doctor=new ArrayList<>();
        for (DoctorDto doctorDto:dto.getDoctorDtos()){
            Doctor dto1=new Doctor();

            dto1.setName(doctorDto.getName());
            dto1.setEmail(doctorDto.getEmail());
            dto1.setAddress(doctorDto.getAddress());
            dto1.setContactNo(doctorDto.getContactNo());
            dto1.setCode(doctorDto.getCode());
           dto1.setHospitals(hospitals);
            doctor.add(dto1);

        }

        hospital.setDoctors(doctor);

        return hospital;
    }

}
