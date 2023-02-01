package com.example.homework19.Model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Movie {

    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE)
    private Integer id;
    @NotEmpty(message = "The name should not be empty")
    @Size(min = 2, message = "The name length should be more than 2 characters")
    private String name;
    @NotEmpty(message = "The genre should not be empty")
    @Pattern(regexp="(Drama|Action|Comedy)", message = "The genre should be either Drama, Action or Comedy")
    private String genre;
    @NotNull(message = "The rating should not be empty")
    @Min(value = 1, message = "The rating should be greater than 1")
    @Max(value = 5, message = "The rating should not be greater than 5")
    private int rating;
    @NotNull(message = "The duration should not be empty")
    @Min(value = 60, message = "The duration should be more than 60")
    private int duration;
    private Integer directorId;


}
