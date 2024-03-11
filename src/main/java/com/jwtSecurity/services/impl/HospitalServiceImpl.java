package com.jwtSecurity.services.impl;

import com.jwtSecurity.dao.HospitalDao;
import com.jwtSecurity.dto.HospitalDto;
import com.jwtSecurity.mapper.HospitalMapper;
import com.jwtSecurity.model.Hospital;
import com.jwtSecurity.services.HospitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HospitalServiceImpl implements HospitalService {
    @Autowired
    private HospitalDao dao;

    @Override
    public HospitalDto saveHospitalDetails(HospitalDto hospitalDto) {
        Hospital hospital=HospitalMapper.toEntity(hospitalDto);
        Hospital hospital1=dao.save(hospital);
        return HospitalMapper.toDto(hospital1);


       // return HospitalMapper.toDto(dao.save(HospitalMapper.toEntity(hospitalDto)));
    }
}
