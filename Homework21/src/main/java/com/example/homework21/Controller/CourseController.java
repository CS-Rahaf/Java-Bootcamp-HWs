package com.example.homework21.Controller;


import com.example.homework21.Model.Course;
import com.example.homework21.Model.Student;
import com.example.homework21.Service.CourseService;
import com.fasterxml.jackson.databind.node.ObjectNode;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("apis/v1/courses")
public class CourseController {


    private final CourseService courseService;


    @GetMapping("")
    public ResponseEntity getCourses(){
        List<Course> course= courseService.getCourses();

        return ResponseEntity.status(200).body(course);
    }


    @GetMapping("/{id}")
    public ResponseEntity getCourse(@PathVariable Integer id){
        Course course= courseService.getCourse(id);
        return ResponseEntity.status(200).body(course);
    }

    @PostMapping("")
    public ResponseEntity addCourse(@Valid @RequestBody Course course){
        courseService.addCourse(course);
        return ResponseEntity.status(200).body("Course has been added Successfully");
    }


    @PutMapping("/{id}")
    public ResponseEntity updateCourse(@PathVariable Integer id, @Valid @RequestBody Course course){

        courseService.updateCourse(id,course);
        return ResponseEntity.status(200).body("Course has been updated Successfully");
    }


    @DeleteMapping ("/{id}")
    public ResponseEntity deleteCourse(@PathVariable Integer id){
        courseService.deleteCourse(id);
        return ResponseEntity.status(200).body("Course has been deleted Successfully");
    }

    @PostMapping("/assign")
    public ResponseEntity assignCourseToTeacher(@Valid @RequestBody ObjectNode objectNode){
        courseService.assignCourseToTeacher(objectNode);
        return ResponseEntity.status(200).body("Course has been assigned to teacher Successfully");
    }

    //Second required endpoint
    @GetMapping("/{id}/teacher")
    public ResponseEntity getTeacherNameByCourseId(@PathVariable Integer id){
        String teacherName = courseService.getTeacherByCourseId(id);
        return ResponseEntity.status(200).body(teacherName);
    }

    @GetMapping("/{id}/students")
    public ResponseEntity getStudentInCourse(@PathVariable Integer id){
       List<Student> students = courseService.getStudentList(id);
        return ResponseEntity.status(200).body(students);
    }
    
}
