package com.example.homework21.Service;


import com.example.homework21.Exception.ApiException;
import com.example.homework21.Model.Course;
import com.example.homework21.Model.Student;
import com.example.homework21.Model.Teacher;
import com.example.homework21.Repository.CourseRepository;
import com.fasterxml.jackson.databind.node.ObjectNode;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CourseService {
    
    private final CourseRepository courseRepository;
    private final TeacherService teacherService;


    public List<Course> getCourses(){
        return courseRepository.findAll();
    }


    public Course getCourse(Integer id){
        Course Course = courseRepository.findCourseById(id);
        if(Course==null){
            throw new ApiException("Course not found");
        }

        return Course;
    }
    public void addCourse(Course course){
        courseRepository.save(course);
    }
    public void updateCourse(Integer id, Course course){
        Course currentCourse = courseRepository.findCourseById(id);
        if(currentCourse==null){
            throw new ApiException("Course not found");
        }

        course.setId(currentCourse.getId());
        courseRepository.save(course);
    }

    public void deleteCourse(Integer id){
        Course currentCourse = courseRepository.findCourseById(id);

        if(currentCourse == null){
            throw new ApiException("Course not found");
        }
        courseRepository.deleteById(id);
    }

    public void assignCourseToTeacher(ObjectNode objectNode){

        Integer teacherId = objectNode.get("teacherId").asInt();
        Teacher teacher= teacherService.getTeacher(teacherId);

        Integer courseId = objectNode.get("courseId").asInt();
        Course course= getCourse(courseId);

        course.setTeacher(teacher);
        courseRepository.save(course);

    }

    public String getTeacherByCourseId(Integer id){
        Course course = courseRepository.findCourseById(id);
       String teacherName = course.getTeacher().getName();
        return teacherName;
    }

    public List<Student> getStudentList(Integer id){
        Course course = courseRepository.findCourseById(id);
        List<Student> students = course.getStudents();
        return students;
    }



}
