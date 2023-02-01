package com.example.homework19.Repository;

import com.example.homework19.Model.Director;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DirectorRepository extends JpaRepository<Director, Integer> {
    public Director findDirectorById(Integer id);

}
