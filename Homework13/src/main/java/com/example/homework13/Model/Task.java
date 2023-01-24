package com.example.homework13.Model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class Task {
    private String id;
    private String title;
    private String description;
    private String status;
    private LocalDate date;


}
