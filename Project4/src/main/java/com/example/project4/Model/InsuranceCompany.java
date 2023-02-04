package com.example.project4.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.springframework.data.repository.cdi.Eager;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class InsuranceCompany {

    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE)
    private Integer id;

    @NotEmpty(message = "The name should not be empty")
    @Size(min = 2, message = "The name length should be more than 2 characters")
    @Column(columnDefinition = "varchar(20) not null")
    private String name;

    @NotEmpty(message = "The email should not be empty")
    @Email
    @Column(columnDefinition = "varchar(30) not null", unique = true)
   /* @Column( unique = true)*/
    private String email;

    @NotNull(message = "The VIP insurance price should not be empty")
    @Column(columnDefinition = "float not null")
    private double VipPrice;

    @NotNull(message = "The gold insurance price should not be empty")
    @Column(columnDefinition = "float not null")
    private double goldPrice;
    @NotNull(message = "The silver insurance price should not be empty")
    @Column(columnDefinition = "float not null")
    private double silverPrice;

    @NotNull(message = "The basic insurance price should not be empty")
    @Column(columnDefinition = "float not null")
    private double basicPrice;





}
