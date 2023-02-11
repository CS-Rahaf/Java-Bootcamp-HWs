package com.example.project5.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Store {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "The name should not be empty")
    @Column(columnDefinition = "varchar(20) not null")
    @Size(min = 2, message = "The name should be more than 2 character")
    private String name;


    @OneToOne(cascade = CascadeType.ALL , mappedBy= "store")
    @PrimaryKeyJoinColumn
    private Location location;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "store")
    private List<Book> books;


    @ManyToMany(mappedBy = "stores")
    private List<Customer> customers;
}
