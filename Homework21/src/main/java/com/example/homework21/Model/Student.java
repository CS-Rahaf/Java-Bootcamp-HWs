package com.example.homework21.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
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
public class Student {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "The name should not be empty")
    @Column(columnDefinition = "varchar(20) not null unique")
    @Size(min = 2, message = "The name must be more than 2 character")
    private String name;

    private int age;


    @NotEmpty(message = "The major should not be empty")
    @Column(columnDefinition = "varchar(20) not null")
    @Size(min = 2, message = "The major name must be more than 2 character")
    private String major;


    @ManyToMany(mappedBy = "students")
    private List<Course> courseList;


}
