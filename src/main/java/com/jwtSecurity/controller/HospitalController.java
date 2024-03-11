package com.jwtSecurity.controller;

import com.jwtSecurity.dto.ApiResponse;
import com.jwtSecurity.dto.HospitalDto;
import com.jwtSecurity.dto.VirusDto;
import com.jwtSecurity.services.HospitalService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class HospitalController {
    @Autowired
    private HospitalService hospitalService;
//    @Autowired
//    private HttpServletRequest httpServletRequest;

    @PostMapping("/hospital")
    public ResponseEntity<ApiResponse> saveHospital(@RequestBody HospitalDto dto){
       HospitalDto dto1= hospitalService.saveHospitalDetails(dto);
        ApiResponse response=new ApiResponse();
        response.setApiTimestamp(new Date());
        response.setPath("null");
        response.setStatus(HttpStatus.OK.name());
        response.setData(dto1);
        return ResponseEntity.ok().body(response);
    }
}
