/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.classJump.models;

import org.classJump.Exceptions.CourseNotFoundException;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author CoNNect
 */
public class Teacher implements Serializable {

    private String name;
    private String email;
    private String password;
    private ArrayList<Course> Courses;

    public Teacher(String name, String email, String passWord) {
        this.name = name;
        this.email = email;
        this.password = passWord;
        this.Courses = new ArrayList();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getpassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public ArrayList<Course> getCourses() {
        return Courses;
    }

    public void setCourses(ArrayList<Course> Courses) {
        this.Courses = Courses;
    }

    public void addCourse(Course course) {
        Courses.add(course);

    }

    public void deleteCourse(String courseName) {
        try {
            ArrayList<Course> courses = this.searchCourse(courseName);
            this.Courses.removeAll(courses);
        } catch (CourseNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    private ArrayList<Course> searchCourse(String courseName) throws CourseNotFoundException {
        ArrayList<Course> courses = new ArrayList<>();
        for (Course course : this.Courses) {
            if (course.getName() != null && course.getName().equalsIgnoreCase(courseName)) {
                courses.add(course);
            }
        }
        if (courses.isEmpty())
            throw new CourseNotFoundException("Course'" + courseName + "'not found");
        return courses;
    }
}
