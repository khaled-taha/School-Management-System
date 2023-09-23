/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.classJump.models;

import java.util.ArrayList;

public class Course {
    private String id;
    private String name;
    private String description;
    private ArrayList<Lecture> Lectures;
    private ArrayList<Sheet> Sheets;

    public Course(String code, String name, String description, ArrayList<Lecture> lectures, ArrayList<Sheet> sheets) {
        this.id = code;
        this.name = name;
        this.description = description;
        Lectures = lectures;
        Sheets = sheets;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ArrayList<Lecture> getLectures() {
        return Lectures;
    }

    public void setLectures(ArrayList<Lecture> lectures) {
        Lectures = lectures;
    }

    public ArrayList<Sheet> getSheets() {
        return Sheets;
    }

    public void setSheets(ArrayList<Sheet> sheets) {
        Sheets = sheets;
    }
}
