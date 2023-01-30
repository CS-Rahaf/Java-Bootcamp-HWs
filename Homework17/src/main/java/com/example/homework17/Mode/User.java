package com.example.homework17.Mode;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "The name shouldn't be empty")
    @Column(columnDefinition = "varchar(10) not null")
    private String name;

    @NotEmpty(message = "The username shouldn't be empty")
    @Size(min = 5, message = "username length should be greater than 5 characters")
    @Column(columnDefinition = "varchar(15) not null unique")
    private String username;

    @NotEmpty(message = "The password shouldn't be empty")
    @Column(columnDefinition = "varchar(20) not null")
    private String password;

    @NotEmpty(message = "The password shouldn't be empty")
    @Column(columnDefinition = "varchar(30) not null unique")
    @Email(message = "It should be valid email")
    private String email;
    @NotEmpty(message = "The role shouldn't be empty")
    @Pattern(regexp="(Admin|user)", message = "The role should be either Admin or Customer")
    @Column(columnDefinition = "varchar(5) not null")
    private String role;

    @NotNull(message = "The age shouldn't be empty")
   @Column(columnDefinition = " int default 0 not null")
    private int age;



}
