package com.example.week3project.Model;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class User {

    @NotEmpty(message = "The Id shouldn't be empty")
    @Size(min = 3, max = 3 , message = "Id length should be 3 characters")
    private String id;

    @NotEmpty(message = "Username shouldn't be empty")
    @Size(min = 5, message = "Username length should be at least 5 characters")
    private String username;

    @NotEmpty(message = "Password shouldn't be empty")
    @Size(min = 6, message = "Password length should be at least 5 characters")
    //@Pattern(regexp="^((?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])){6,20}$")
    private String password;

    @NotEmpty(message = "Email shouldn't be empty")
    @Email(message = "It's not a valid email")
    private String email;

    @NotEmpty(message = "The role shouldn't be empty")
    @Pattern(regexp="(Admin|Customer)", message = "The role should be either Admin or Customer")
    private String role;

    @NotNull(message = "The balance shouldn't be empty")
    @Positive
    private double balance;




}
