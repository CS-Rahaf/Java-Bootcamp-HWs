package com.example.homework21.Service;

import com.example.homework21.Exception.ApiException;
import com.example.homework21.Model.Teacher;
import com.example.homework21.Repository.TeacherRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TeacherService {

    private final TeacherRepository teacherRepository;


    public List<Teacher> getTeachers(){
        return teacherRepository.findAll();
    }


    public Teacher getTeacher(Integer id){
        Teacher teacher = teacherRepository.findTeacherById(id);
        if(teacher==null){
            throw new ApiException("Teacher not found");
        }

        return teacher;
    }
    public void addTeacher(Teacher teacher){
        teacherRepository.save(teacher);
    }
    public void updateTeacher(Integer id, Teacher teacher){
        Teacher currentTeacher = teacherRepository.findTeacherById(id);
        if(currentTeacher==null){
            throw new ApiException("Teacher not found");
        }

        teacher.setId(currentTeacher.getId());
        teacherRepository.save(teacher);
    }

    public void deleteTeacher(Integer id){
        Teacher currentTeacher = teacherRepository.findTeacherById(id);

        if(currentTeacher == null){
            throw new ApiException("Teacher not found");
        }
        teacherRepository.deleteById(id);
    }


}
