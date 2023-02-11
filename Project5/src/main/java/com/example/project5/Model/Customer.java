package com.example.project5.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "The name should not be empty")
    @Column(columnDefinition = "varchar(20) not null")
    @Size(min = 2, message = "The name should be more than 2 character")
    private String name;

    @NotEmpty(message = "The phone number should not be empty")
    @Column(columnDefinition = "varchar(10) not null")
    @Size(min = 10, max = 10, message = "The input should be valid phone number")
    private String phoneNumber;


    @NotEmpty(message = "The email should not be empty")
    @Column(columnDefinition = "varchar(30) not null unique")
    @Email
    private String email;


    @ManyToMany
    @JsonIgnore
    private List<Store> stores;

}
