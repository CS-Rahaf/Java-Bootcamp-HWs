package com.example.homework28.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "The product name should not be empty")
    private String name;


    @NotNull(message = "The product price should not be empty")
    private double price;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "product")
    private List<Orderr> orderrs;

}
