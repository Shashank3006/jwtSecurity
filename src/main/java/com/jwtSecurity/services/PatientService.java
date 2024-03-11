package com.jwtSecurity.services;

import com.jwtSecurity.dto.PatientDto;
import com.jwtSecurity.model.Patient;

public interface PatientService {
    public PatientDto createPatient(PatientDto patientDto);
    public PatientDto getPatientById(Long id);
}
