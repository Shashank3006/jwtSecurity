package com.jwtSecurity.model;

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
@Entity
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  long id;
    private String email;
    private  String name;
    private String contactNo;
    @OneToOne(cascade = CascadeType.ALL)
    private  Passport passport;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Virus> virus;


}
