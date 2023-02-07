package com.example.homework21.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "The name should not be empty")
    @Column(columnDefinition = "varchar(20) not null")
    @Size(min = 2, message = "The name must be more than 2 character")
    private String name;

    @NotNull(message = "The age should not be empty")
    private int age;
    @NotEmpty(message = "The email should not be empty")
    @Column(columnDefinition = "varchar(30) not null unique")
    @Email
    private String email;
    private double salary;


    @OneToOne(cascade = CascadeType.ALL , mappedBy= "teacher")
    @PrimaryKeyJoinColumn
    private Address address;


    @OneToMany(cascade = CascadeType.ALL, mappedBy = "teacher")
    private List<Course> courses;




}
