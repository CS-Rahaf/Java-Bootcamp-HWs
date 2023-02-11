package com.example.project5.Model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Location {

    @Id
    private Integer id;

    @NotEmpty(message = "The area should not be empty")
    @Column(columnDefinition = "varchar(20) not null")
    private String area;

    @NotEmpty(message = "The street should not be empty")
    @Column(columnDefinition = "varchar(20) not null")
    private String street;


    @OneToOne
    @MapsId
    @JsonIgnore
    private Store store;

}
