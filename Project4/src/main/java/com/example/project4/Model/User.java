package com.example.project4.Model;


import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Entity
@AllArgsConstructor
@Data
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    @NotEmpty(message = "The name should not be empty")
    @Column(columnDefinition = "varchar(20) not null")
    @Size(min = 2, message = "name must be more than 2 character")
    private String name;

    @NotNull(message = "age should be filled")
    private int age;
    @NotEmpty(message = "The email should not be empty")
    @Column(columnDefinition = "varchar(30) not null unique")
    @Email
    private String email;

    private Integer InsuranceCompanyID;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate startDate;

    @Pattern(regexp="(Valid|Not Valid)", message = "The insurance status should be either Valid or Not Valid")
    @Column(columnDefinition = "varchar(10)")
    private String insuranceStatus;

    @Pattern(regexp="(VIP|Gold|Silver|Basic)", message = "The insurance category should be either VIP, Gold, Silver or Basic")
    @Column(columnDefinition = "varchar(8) ")
    private String insuranceCategory;


}
