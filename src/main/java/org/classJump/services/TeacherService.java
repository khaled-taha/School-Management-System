package org.classJump.services;

import org.classJump.repositories.FileRepository;
import org.classJump.models.Teacher;

public class TeacherService {

    private FileRepository<Teacher> teacherRepository;

    public TeacherService(FileRepository<Teacher> teacherRepository) {
        this.teacherRepository = teacherRepository;
    }


    public void addTeacherCourse(String teacherName, String courseName){
        // code
    }

    public void deleteTeacherCourse(String teacherName, String courseName){
        // code
    }


    public Teacher login(String username, String password){
        // code
        return null;
    }

    public Teacher register(String name, String email, String password){
        // At first, make sure that the new email is unique
        // rest of code
        return null;
    }


}
