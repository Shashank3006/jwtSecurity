package com.jwtSecurity.controller;

import com.jwtSecurity.dto.ApiResponse;
import com.jwtSecurity.dto.VirusDto;
import com.jwtSecurity.services.VirusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
public class VirusController {
    @Autowired
    private VirusService service;
    @PostMapping("/virus")
    public ResponseEntity<ApiResponse> saveVirus(@RequestBody VirusDto dto){
        VirusDto dto1=service.saveVirus(dto);
        ApiResponse response=new ApiResponse();
        response.setApiTimestamp(new Date());
        response.setPath("null");
        response.setStatus(HttpStatus.OK.name());
        response.setData(dto1);
        return ResponseEntity.ok().body(response);
    }
    @GetMapping("/virus/{name}")
    public ResponseEntity<ApiResponse> findByName(@PathVariable String name){
        VirusDto dto1=service.findByName(name);
        ApiResponse response=new ApiResponse();
        response.setApiTimestamp(new Date());
        response.setPath("null");
        response.setStatus(HttpStatus.OK.name());
        response.setData(dto1);
        return ResponseEntity.ok().body(response);
    }

}
