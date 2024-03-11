package com.jwtSecurity.controller;

import com.jwtSecurity.dto.PatientDto;
import com.jwtSecurity.services.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class PatientController {
    @Autowired
    public PatientService patientService;

    @PostMapping("/createPatient")
    public PatientDto createPatient(@RequestBody PatientDto patientDto){
        System.out.println("hello post");
        return patientService.createPatient(patientDto);
    }
    @GetMapping("/get/{id}")
    public PatientDto getPatientById(@PathVariable Long id){
       return patientService.getPatientById(id);

    }
}
