package com.jwtSecurity.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  long id;
    private String code;
    private  String name;
    private String address;
    private String email;
    private String contactNo;
    @ManyToMany(cascade = CascadeType.ALL)
    private List<Hospital>hospitals;

}
