package com.example.homework29.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Response {

    private String message;
    private Integer status;
}
