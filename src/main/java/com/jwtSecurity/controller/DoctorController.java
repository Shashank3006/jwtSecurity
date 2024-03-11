package com.jwtSecurity.controller;

import com.jwtSecurity.dto.ApiResponse;
import com.jwtSecurity.dto.DoctorDto;
import com.jwtSecurity.services.DoctorService;
import com.jwtSecurity.services.HospitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class DoctorController {
    @Autowired
    private DoctorService doctorService ;

    @PostMapping("/doctor")
    public ResponseEntity<ApiResponse> saveHospital(@RequestBody DoctorDto dto){
       DoctorDto dto1= doctorService.saveDoctorDetails(dto);
        ApiResponse response=new ApiResponse();
        response.setApiTimestamp(new Date());
        response.setPath("null");
        response.setStatus(HttpStatus.OK.name());
        response.setData(dto1);
        return ResponseEntity.ok().body(response);
    }
}
