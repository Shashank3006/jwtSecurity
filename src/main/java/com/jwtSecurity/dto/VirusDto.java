package com.jwtSecurity.dto;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
@Getter
@Setter

public class VirusDto {


    private  long id;
    private String variant;
    private  String name;
    @ManyToOne
    private PatientDto patientDto;
}
