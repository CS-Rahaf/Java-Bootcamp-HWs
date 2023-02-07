package com.example.homework21.Controller;


import com.example.homework21.Model.Teacher;
import com.example.homework21.Service.TeacherService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/apis/v1/teachers")
@AllArgsConstructor
public class TeacherController {


    private final TeacherService teacherService;



    @GetMapping("")
    public ResponseEntity getTeachers(){
        List<Teacher> teachers= teacherService.getTeachers();

        return ResponseEntity.status(200).body(teachers);
    }

    @GetMapping("/{id}")
    public ResponseEntity getTeacher(@PathVariable Integer id){
        Teacher teachers= teacherService.getTeacher(id);

        return ResponseEntity.status(200).body(teachers);
    }

    @PostMapping("")
    public ResponseEntity addTeacher(@Valid @RequestBody Teacher teacher){
        teacherService.addTeacher(teacher);
        return ResponseEntity.status(200).body("Teacher has been added Successfully");
    }


    @PutMapping("/{id}")
    public ResponseEntity updateTeacher(@PathVariable Integer id, @Valid @RequestBody Teacher teacher){

        teacherService.updateTeacher(id,teacher);
        return ResponseEntity.status(200).body("Teacher has been updated Successfully");
    }


    @DeleteMapping ("/{id}")
    public ResponseEntity deleteTeacher(@PathVariable Integer id){
        teacherService.deleteTeacher(id);
        return ResponseEntity.status(200).body("Teacher has been deleted Successfully");
    }


    
}
