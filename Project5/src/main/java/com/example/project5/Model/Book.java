package com.example.project5.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "The name should not be empty")
    @Column(columnDefinition = "varchar(20) not null")
    @Size(min = 2, message = "The name should be more than 2 character")
    private String name;

    @NotNull(message = "The book count should not be null")
    private int bookCount;

    @NotEmpty(message = "The genre should not be empty")
    @Column(columnDefinition = "varchar(10) not null")
    private String genre;


    @ManyToOne
    @JoinColumn(name = "store_id", referencedColumnName = "id")
    @JsonIgnore
    private Store store;



}
