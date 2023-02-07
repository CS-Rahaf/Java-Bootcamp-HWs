package com.example.homework21.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address {

    @Id
    private Integer id;

    @NotEmpty(message = "The area should not be empty")
    @Column(columnDefinition = "varchar(20) not null unique")
    private String area;

    @NotEmpty(message = "The street should not be empty")
    @Column(columnDefinition = "varchar(20) not null unique")
    private String street;

    private int buildingNumber;


    @OneToOne
    @MapsId
    @JsonIgnore
    private Teacher teacher;



}
