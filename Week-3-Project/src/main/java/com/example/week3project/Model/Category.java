package com.example.week3project.Model;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Category {

    @NotEmpty(message = "The Id shouldn't be empty")
    @Size(min = 3, max = 3 , message = "Id length should be 3 characters")
    private String id;
    @NotEmpty(message = "Name shouldn't be empty")
    @Size(min = 3, message = "Name length should be at least 3 characters")
    private String name;


}
