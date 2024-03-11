package com.jwtSecurity.mapper;

import com.jwtSecurity.dto.PassportDto;
import com.jwtSecurity.dto.PatientDto;
import com.jwtSecurity.dto.VirusDto;
import com.jwtSecurity.model.Passport;
import com.jwtSecurity.model.Patient;
import com.jwtSecurity.model.Virus;

import java.util.ArrayList;
import java.util.List;

public class PatientMapper {
    public static PatientDto toDto(Patient patient) {
        PatientDto dto = new PatientDto();
        //Patient pa=new Patient();
        dto.setId(patient.getId());
        dto.setName(patient.getName());
        dto.setEmail(patient.getEmail());
        dto.setContactNo(patient.getContactNo());

        PassportDto passport = new PassportDto();
        passport.setId(patient.getPassport().getId());
        passport.setPassportNo(patient.getPassport().getPassportNo());
        dto.setPassportDto(passport);

        List<VirusDto> virusDtos = new ArrayList<>();
        for (Virus virus:patient.getVirus()){
            VirusDto dto1 = new VirusDto();
        dto1.setId(virus.getId());
        dto1.setName(virus.getName());
        dto1.setVariant(virus.getVariant());
      //  dto1.setPatientDto(dto);
        virusDtos.add(dto1);
    }
        dto.setVirusDto(virusDtos);

        return dto;
    }
    public static Patient toEntity(PatientDto dto){
        Patient patient=new Patient();
        patient.setName(dto.getName());
        patient.setEmail(dto.getEmail());
        patient.setContactNo(dto.getContactNo());

        Passport passport   =new  Passport();
        passport.setPassportNo(dto.getPassportDto().getPassportNo());
        patient.setPassport(passport);

        List<Virus> virus = new ArrayList<>();
        for (VirusDto vir: dto.getVirusDto()){
            Virus dto1 = new Virus();
            dto1.setName(vir.getName());
            dto1.setVariant(vir.getVariant());
            dto1.setPatient(patient);
            virus.add(dto1);
        }
        patient.setVirus(virus);

//        Virus virus=new Virus();
//        virus.setName(dto.getVirusDto().getName());
//        virus.setVariant(dto.getVirusDto().getVariant());
//
//        patient.setVirus(virus);
         return patient;


    }
}
