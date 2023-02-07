package com.example.homework21.Repository;

import com.example.homework21.Model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Integer> {
     Teacher findTeacherById(Integer id);




}
