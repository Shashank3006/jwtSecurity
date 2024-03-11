package com.jwtSecurity.services.impl;

import com.jwtSecurity.dao.PatientDao;
import com.jwtSecurity.dto.PatientDto;
import com.jwtSecurity.exceptions.PatientRecordNotFoundException;
import com.jwtSecurity.mapper.PatientMapper;
import com.jwtSecurity.model.Patient;
import com.jwtSecurity.services.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PatientServiceImpl implements PatientService {
    @Autowired
    private PatientDao dao;
    @Override
    public PatientDto createPatient(PatientDto patientDto) {
        Patient patient=PatientMapper.toEntity(patientDto);
Patient patient1=dao.save(patient);
PatientDto dto=PatientMapper.toDto(patient1);
        return dto;
    }

    @Override
    public PatientDto getPatientById(Long id) {
        Optional<Patient> dto=dao.findById(id);
        if(dto.isEmpty()){
           throw new PatientRecordNotFoundException("patient with id "+id+" is missing or invalid");
        }
        Patient patient=dto.get();

        return PatientMapper.toDto(patient);

    }
}
