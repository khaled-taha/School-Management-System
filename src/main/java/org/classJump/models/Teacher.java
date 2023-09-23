/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.classJump.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

/**
 *
 * @author CoNNect
 */
public class Teacher implements Serializable {

    private String name;
    private String email;
    private String password;
    private ArrayList<String> CoursesIds;

    public Teacher(String name, String email, String passWord) {
        this.name = name;
        this.email = email;
        this.password = passWord;
        this.CoursesIds = new ArrayList();
    }

    public Teacher(String[] attributes) {
        this.name = attributes[0];
        this.email = attributes[1];
        this.password = attributes[2];
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public ArrayList<String> getCoursesIds() {
        return CoursesIds;
    }

    public void setCoursesIds(ArrayList<String> coursesIds) {
        CoursesIds = coursesIds;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Teacher teacher = (Teacher) o;
        return Objects.equals(name, teacher.name) && Objects.equals(email, teacher.email) && Objects.equals(password, teacher.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, email, password);
    }
}
