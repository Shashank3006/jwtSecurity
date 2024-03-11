package com.jwtSecurity.dao;

import com.jwtSecurity.model.Hospital;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HospitalDao extends JpaRepository<Hospital,Long> {
}
