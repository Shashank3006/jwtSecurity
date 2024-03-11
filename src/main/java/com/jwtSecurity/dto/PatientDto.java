package com.jwtSecurity.dto;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class PatientDto {

    private  long id;
    private String email;
    private  String name;
    private String contactNo;
    @OneToOne
    private PassportDto passportDto;
    @OneToMany
    private List<VirusDto> virusDto;


}
