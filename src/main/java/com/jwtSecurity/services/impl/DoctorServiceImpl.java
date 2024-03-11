package com.jwtSecurity.services.impl;

import com.jwtSecurity.dao.DoctorDao;
import com.jwtSecurity.dao.HospitalDao;
import com.jwtSecurity.dto.DoctorDto;
import com.jwtSecurity.mapper.DoctorMapper;
import com.jwtSecurity.services.DoctorService;
import com.jwtSecurity.services.HospitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DoctorServiceImpl implements DoctorService {
    @Autowired
    private DoctorDao dao;

    @Override
    public DoctorDto saveDoctorDetails(DoctorDto doctorDto) {


        return DoctorMapper.toDto(dao.save(DoctorMapper.toEntity(doctorDto)));
    }
}
