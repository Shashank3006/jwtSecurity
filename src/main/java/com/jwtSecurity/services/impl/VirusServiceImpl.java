package com.jwtSecurity.services.impl;

import com.jwtSecurity.dao.VirusDao;
import com.jwtSecurity.dto.VirusDto;
import com.jwtSecurity.mapper.VirusMapper;
import com.jwtSecurity.model.Virus;
import com.jwtSecurity.services.VirusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class VirusServiceImpl implements VirusService {
    @Autowired
    private VirusDao dao;
    @Override
    public VirusDto saveVirus(VirusDto dto) {
       Virus virus= VirusMapper.toEntity(dto);
        Virus virus1=dao.save(virus);



        return VirusMapper.toDto(virus1);
    }

    @Override
    public VirusDto findByName(String name) {
        Optional<Virus> virus=dao.findByName(name);
//
        return virus.map(VirusMapper::toDto).orElse(null);


    }
}
