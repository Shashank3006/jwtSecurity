package com.jwtSecurity.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter

public class ApiResponse {
    private String status;
    private Date apiTimestamp;
    private String path;
    private Object data;
    private Object error;
}
