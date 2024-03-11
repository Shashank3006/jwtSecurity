package com.jwtSecurity.dao;

import com.jwtSecurity.model.Virus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VirusDao extends JpaRepository<Virus,Long> {
    public Optional<Virus> findByName(String name);
}
