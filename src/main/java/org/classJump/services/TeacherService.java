package org.classJump.services;

import org.apache.poi.ss.formula.functions.Count;
import org.classJump.models.Course;
import org.classJump.repositories.FileRepository;
import org.classJump.models.Teacher;

import java.util.List;

public class TeacherService {

    private FileRepository<Teacher> teacherRepository;
    private FileRepository<Course> courseRepository;

    public TeacherService(FileRepository<Teacher> teacherRepository) {
        this.teacherRepository = teacherRepository;
    }


    public void addTeacherCourse(String teacherName, String courseName) throws Exception {
        // find All courses
        List<Course> courses = this.courseRepository.findAll();
        // Extract the course object from the list

        Course savedCourse = null;
        for (Course course: courses) {
            if(course != null && course.getName().equals(courseName)){
                savedCourse = course;
            }
        }

        // find teacher
        List<Teacher> teachers = this.teacherRepository.findAll();
        for (Teacher teacher: teachers) {
            if(teacher != null && teacher.getName().equals(courseName)){
                teacher.getCoursesIds().add(savedCourse.getId());
            }
        }

        // saveAll
        this.teacherRepository.saveAll(teachers);
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
