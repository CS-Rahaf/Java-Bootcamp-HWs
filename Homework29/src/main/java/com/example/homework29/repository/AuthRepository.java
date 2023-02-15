package com.example.homework29.repository;

import com.example.homework29.model.MyUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthRepository  extends JpaRepository<MyUser,Integer> {

    MyUser findMyUserById(Integer id);
    MyUser findMyUserByUsername(String username);
}
