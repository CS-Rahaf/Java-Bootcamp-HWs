package com.example.project4.Repository;

import com.example.project4.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepositry extends JpaRepository<User,Integer> {
    User findUserById(Integer id);
    List<User> findAllByInsuranceCategory(String category);

    List<User> findAllByAgeGreaterThan(int age);

}
