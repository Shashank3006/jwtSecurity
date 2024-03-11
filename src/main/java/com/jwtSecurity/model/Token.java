package com.jwtSecurity.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Cascade;


@Entity
//@Table(name = "token_tb")
@Getter
@Setter
public class  Token {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  long id;
    private String token;
    private boolean isLoggedOut;
    @ManyToOne(fetch = FetchType.LAZY)
    private User user;
}
