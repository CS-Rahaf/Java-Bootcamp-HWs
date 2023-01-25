package com.example.homework14.Model;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Employee {

    @NotEmpty(message = "The id shouldn't be empty")
    @Size(min = 3, message = "The id length should be more than 2")
    private String id;

    @NotEmpty(message = "The name shouldn't be empty")
    @Size(min = 5, message = "The name length should be greater than 4")
    private String name;

    @NotEmpty(message = "The age shouldn't be empty")
    @Min(value = 26, message = "The age should be greater than 25")
    @Positive(message = "The age should be valid")
    private String age;

    @NotEmpty(message = "The role shouldn't be empty")
    @Pattern(regexp="(supervisor|coordinator)")
    private String role;
    @AssertFalse
    private Boolean onLeave;

    @NotNull(message = "The employment year shouldn't be empty")
    @Min(value = 1990, message = "The employment year should be valid")
    @Max(value = 2040, message = "The employment year should be valid")
    private int employmentYear;

    @NotNull(message = "The annual leave shouldn't be empty")
    @PositiveOrZero(message = "The annual leave should be valid number ")
    private int annualLeave;


}
