package com.jwtSecurity.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Hospital {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name="hospital_Id")
    private  long id;
    private String code;
    private  String name;
    private String location;
    @ManyToMany(cascade = CascadeType.ALL)
    private List<Doctor> doctors;
}
