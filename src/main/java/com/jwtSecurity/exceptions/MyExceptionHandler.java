package com.jwtSecurity.exceptions;

import com.jwtSecurity.dto.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class MyExceptionHandler {
    @ExceptionHandler(PatientRecordNotFoundException.class)
    private ResponseEntity<ApiResponse> responsePatientRecordNotFound(PatientRecordNotFoundException e){
        ApiResponse response=new ApiResponse();
        response.setPath("null");
        response.setStatus(HttpStatus.NOT_FOUND.name());
        response.setData(null);
        response.setApiTimestamp(new Date());
        Map<String,String> errorMap=new HashMap<>();
        errorMap.put("errorMsg",e.getExceptionMsg());
        response.setError(errorMap);
        return ResponseEntity.ok().body(response);

    }

}
