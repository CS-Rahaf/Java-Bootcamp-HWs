package com.example.homework29.repository;


import com.example.homework29.model.MyUser;
import com.example.homework29.model.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TodoRepository extends JpaRepository<Todo,Integer> {

    Todo findTodoById(Integer id);

    List<Todo> findAllByMyUser(MyUser myUser);
}
