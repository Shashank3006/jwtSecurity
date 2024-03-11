package com.jwtSecurity.exceptions;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor

@AllArgsConstructor
public class PatientRecordNotFoundException extends RuntimeException {
    private String exceptionMsg;
//    public PatientRecordNotFoundException(){}
//    public  PatientRecordNotFoundException(String exceptionMsg){
//        this.exceptionMsg=exceptionMsg;
//
//    }
    public  String getExceptionMsg(){
        return exceptionMsg;

    }


}
