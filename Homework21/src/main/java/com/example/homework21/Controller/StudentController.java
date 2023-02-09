package com.example.homework21.Controller;

import com.example.homework21.Model.Student;
import com.example.homework21.Service.StudentService;
import com.fasterxml.jackson.databind.node.ObjectNode;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("apis/v1/students")
public class StudentController {


    private final StudentService studentService;


    @GetMapping("")
    public ResponseEntity getStudents(){
        List<Student> student= studentService.getStudents();

        return ResponseEntity.status(200).body(student);
    }


    @GetMapping("/{id}")
    public ResponseEntity getStudent(@PathVariable Integer id){
        Student student= studentService.getStudent(id);
        return ResponseEntity.status(200).body(student);
    }

    @PostMapping("")
    public ResponseEntity addStudent(@Valid @RequestBody Student student){
        studentService.addStudent(student);
        return ResponseEntity.status(200).body("Student has been added Successfully");
    }


    @PutMapping("/{id}")
    public ResponseEntity updateStudent(@PathVariable Integer id, @Valid @RequestBody Student student){

        studentService.updateStudent(id,student);
        return ResponseEntity.status(200).body("Student has been updated Successfully");
    }


    @DeleteMapping ("/{id}")
    public ResponseEntity deleteStudent(@PathVariable Integer id){
        studentService.deleteStudent(id);
        return ResponseEntity.status(200).body("Student has been deleted Successfully");
    }


    @PostMapping("/assign")
    public ResponseEntity assignCourseToTeacher(@Valid @RequestBody ObjectNode objectNode){
        studentService.assignStudentToCourse(objectNode);
        return ResponseEntity.status(200).body("Course has been assigned to student Successfully");
    }


    @PatchMapping("/major/{id}")
    public ResponseEntity changeMajor(@PathVariable Integer id,@Valid @RequestBody ObjectNode objectNode){
        studentService.changeMajor(id, objectNode);
        return ResponseEntity.status(200).body("Major has been changed Successfully ");
    }





}
