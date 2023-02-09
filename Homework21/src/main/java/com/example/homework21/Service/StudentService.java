package com.example.homework21.Service;

import com.example.homework21.Exception.ApiException;
import com.example.homework21.Model.Course;
import com.example.homework21.Model.Student;
import com.example.homework21.Repository.CourseRepository;
import com.example.homework21.Repository.StudentRepository;
import com.fasterxml.jackson.databind.node.ObjectNode;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
@AllArgsConstructor
public class StudentService {


    private final StudentRepository studentRepository;
    private final CourseService courseService;
    private final CourseRepository courseRepository;


    public List<Student> getStudents(){
        return studentRepository.findAll();
    }


    public Student getStudent(Integer id){
        Student student = studentRepository.findStudentById(id);
        if(student==null){
            throw new ApiException("Student not found");
        }

        return student;
    }
    public void addStudent(Student student){
        studentRepository.save(student);
    }
    public void updateStudent(Integer id, Student student){
        Student currentStudent = studentRepository.findStudentById(id);
        if(currentStudent==null){
            throw new ApiException("Student not found");
        }

        student.setId(currentStudent.getId());
        studentRepository.save(student);
    }

    public void deleteStudent(Integer id){
        Student currentStudent = studentRepository.findStudentById(id);

        if(currentStudent == null){
            throw new ApiException("Student not found");
        }
        studentRepository.deleteById(id);
    }

    public void assignStudentToCourse(ObjectNode objectNode){

        Integer studentId = objectNode.get("studentId").asInt();
        Student student= getStudent(studentId);

        Integer courseId = objectNode.get("courseId").asInt();
        Course course = courseService.getCourse(courseId);

        student.getCourseList().add(course);
        studentRepository.save(student);

        course.getStudents().add(student);
        courseRepository.save(course);
    }

    public void changeMajor(Integer id, ObjectNode objectNode){
        Student currentStudent= getStudent(id);
        String major = objectNode.get("major").asText();
        currentStudent.setMajor(major);

        currentStudent.getCourseList().clear();
        studentRepository.save(currentStudent);
    }


}
